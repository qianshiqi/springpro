<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>支付流水</title>
    <script type="text/javascript" src="../scripts/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="../scripts/json2.js"></script>
    <script type="text/javascript" src="../scripts/common.js"></script>
</head>
<body>
<div>
    <form id="form_query" method="post" action="/sandpay-gateway-demo/orderCreate">
        订单金额<input type="text" name="totalAmount" id="totalAmount" value="000000000012"/><br/>
        订单标题<input type="text" name="subject" id="subject" value="话费充值"/><br/>
        订单描述<input type="text" name="body" id="body" value="用户购买话费0.12"/><br/>
        订单超时时间<input type="text" name="txnTimeOut" id="txnTimeOut" value=""/><br/>
        支付模式<input type="text" name="payMode" id="payMode" value="bank_pc"/><br/>
        支付类型:<select name="payType" id="payType">
        <option value="1" selected="selected">借记卡</option>
        <option value="2">贷记卡</option>
    </select><br/>
        银行编码:<select name="bankCode" id="bankCode">
        <option value="01020000">工商银行</option>
        <option value="01050000">建设银行</option>
        <option value="01030000" selected="selected">农业银行</option>
        <option value="03080000">招商银行</option>
        <option value="03010000">交通银行</option>
        <option value="01040000">中国银行</option>
    </select><br/>
        客户端IP<input type="text" name="clientIp" id="clientIp" value="127.0.0.1"/><br/>
        异步通知地址<input type="text" name="notifyUrl" id="notifyUrl"
                     value="http://192.168.22.187:8080/sandpay-gateway-demo/notice"/><br/>
        前台通知地址<input type="text" name="frontUrl" id="frontUrl"
                     value="http://192.168.22.187:8080/sandpay-gateway-demo/frontNotice"/><br/>
        商户门店编号<input type="text" name="storeId" id="storeId" value=""/><br/>
        商户终端编号<input type="text" name="terminalId" id="terminalId" value=""/><br/>
        操作员编号<input type="text" name="operatorId" id="operatorId" value=""/><br/>
        业务扩展参数<input type="text" name="bizExtendParams" id="bizExtendParams" value=""/><br/>
        商户扩展参数<input type="text" name="merchExtendParams" id="merchExtendParams" value=""/><br/>
        扩展域<input type="text" name="extend" id="extend" value=""/><br/>
        <input type="submit" value="支付" id="button_pay"/></form>
</div>
</body>
<script>
    //提示到服务器
    $(function () {
        var current = CurentTime();
        $("#orderCode").val(current);
    })
</script>
</html>