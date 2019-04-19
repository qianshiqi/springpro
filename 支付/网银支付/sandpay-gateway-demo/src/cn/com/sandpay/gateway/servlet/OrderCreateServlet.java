/**
 * Copyright : http://www.sandpay.com.cn , 2011-2014
 * Project : sandpay-internetbank-demo
 * $Id$
 * $Revision$
 * Last Changed by pxl at 2018-4-27 下午4:36:58
 * $URL$
 * <p>
 * Change Log
 * Author      Change Date    Comments
 * -------------------------------------------------------------
 * pxl         2018-4-27        Initailized
 */
package cn.com.sandpay.gateway.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

import cn.com.sandpay.gateway.demo.DemoBase;
import cn.com.sandpay.gateway.demo.OrderCreateDemo;
import cn.com.sandpay.gateway.demo.OrderCreateDemo.PayMode;

/**
 *
 * @ClassName ：OrderCreateServlet
 * @author : pxl
 * @Date : 2018-4-27 下午4:36:58
 * @version 2.0.0
 *
 */
public class OrderCreateServlet extends HttpServlet {

    private static final long serialVersionUID = 3184535180522475944L;

    /**
     * 日志对象
     */
    private final static Logger logger = LoggerFactory.getLogger(OrderCreateServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String qryString = req.getQueryString();
        logger.info("qryString:" + qryString);
        logger.debug("method[{}]", new Object[]{req.getMethod()});
        logger.debug("agent[{}]", new Object[]{req.getHeader("user-agent")});

        Map<String, String[]> params = req.getParameterMap();
        JSONObject reqObj = new JSONObject();
        Map<String, String> map = new HashMap<String, String>();
        for (String key : params.keySet()) {
            String[] values = params.get(key);
            if (values.length > 0) {
                reqObj.put(key, values[0]);
                map.put(key, values[0]);
            }
        }

        OrderCreateDemo demo = new OrderCreateDemo();
        String reqAddr = "/order/pay";   //接口报文规范中获取

        //设置报文头
        demo.setHeader(PayMode.bank_pc);

        demo.body.put("orderCode", DemoBase.getOrderCode());                           //商户订单号
        demo.body.put("totalAmount", map.get("totalAmount"));                                  //订单金额
        demo.body.put("subject", map.get("subject"));                                             //订单标题
        demo.body.put("body", map.get("body"));                                         //订单描述
        if (map.get("txnTimeOut") == null || map.get("txnTimeOut") == "") {
            demo.body.put("txnTimeOut", DemoBase.getNextDayTime());                          //订单超时时间
        } else {
            demo.body.put("txnTimeOut", map.get("txnTimeOut"));                                 //订单超时时间
        }

        demo.body.put("payMode", map.get("payMode"));                                           //支付模式
        JSONObject payExtra = new JSONObject();
        payExtra.put("payType", map.get("payType"));
        payExtra.put("bankCode", map.get("bankCode"));
        demo.body.put("payExtra", payExtra);                                //支付扩展域
        demo.body.put("clientIp", map.get("clientIp"));                                    //客户端IP
        demo.body.put("notifyUrl", map.get("notifyUrl"));                         //异步通知地址
        demo.body.put("frontUrl", map.get("frontUrl"));                     //前台通知地址
        demo.body.put("storeId", map.get("storeId"));                                                  //商户门店编号
        demo.body.put("terminalId", map.get("terminalId"));                                               //商户终端编号
        demo.body.put("operatorId", map.get("operatorId"));                                               //操作员编号
        demo.body.put("clearCycle", "");                                               //清算模式
        demo.body.put("royaltyInfo", "");                                              //分账信息
        demo.body.put("riskRateInfo", "");                                             //风控信息域
        demo.body.put("bizExtendParams", map.get("bizExtendParams"));                                          //业务扩展参数
        demo.body.put("merchExtendParams", map.get("merchExtendParams"));                                        //商户扩展参数
        demo.body.put("extend", map.get("extend"));                                                   //扩展域

        JSONObject orderCreateResp = DemoBase.requestServer(demo.header, demo.body, reqAddr);
        if (orderCreateResp.getJSONObject("head").getString("respCode").equals("000000")) {
            logger.info("网银下单成功");

            String credential = orderCreateResp.getJSONObject("body").getString("credential");
            logger.info("生成的支付凭证为：" + credential);

            req.setAttribute("JWP_ATTR", credential);
            String url = "jsp/middle.jsp";
            req.getRequestDispatcher(url).forward(req, resp);
        }

    }


}
