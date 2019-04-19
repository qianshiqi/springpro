								　      ─────────────────────────────────────────     
								                   产品名称：  杉德线上支付
								      JDK：  本示例JDK版本基于jdk1.7
								      Tomcat: 8.0
								                   日期：  2018-04-22
								    ─────────────────────────────────────────

───────────
示例工程目录结构
───────────
sandpay-gateway-demo
  │
  ├src┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈类文件夹
  │  │ 
  │  ├cn.com.sandpay.cashier.sdk
  │  │  │
  │  │  ├CertUtil.java┈┈┈┈证书工具类
  │  │  │	
  │  │  ├CryptoUtil.java┈┈┈┈┈加解密工具类	
  │  │  │
  │  │  ├HttpClient.java┈┈┈┈┈httpclient工具类
  │  │  │  
  │  │  ├SDKConfig.java┈┈┈┈┈读取属性文件并填装配置的属性的配置类 
  │  │  │    
  │  │  └SDKUtil.java┈┈┈┈┈常用方法		
  │  │   
  │  ├cn.com.sandpay.gateway.demo
  │  │  │
  |  |  ├ClearFileDownloadDemo.java┈┈┈┈┈对账单下载示例
  │  │  │
  │  │  ├DemoBase.java┈┈┈┈┈demo基本操作
  │  │  │  
  │  │  ├OrderCreateDemo.java┈┈┈┈┈┈订单创建接口示例
  │  │  │
  │  │  ├OrderQueryDemo.java┈┈┈┈┈订单查询接口示例
  │  │  │
  │  │  └OrderRefundDemo.java┈┈┈┈┈┈┈退货接口示例
  │  │
  │  ├cn.com.sandpay.gateway.filter
  │  │  │
  |  |  └EncodingFilter.java┈┈┈┈┈编码过滤器
  │  │    
  │  ├cn.com.sandpay.gateway.listener
  │  │  │
  |  |  └ContextLoadListener.java┈┈┈┈┈web服务启动监听器，如果为WEB项目，可在此处初始化配置，秘钥等
  │  │     
  │  ├cn.com.sandpay.gateway.servlet
  │  │  │
  |  |  ├NoticeServlet.java┈┈┈┈┈异步通知处理Servlet
  │  │  │
  |  |  ├FrontNoticeServlet.java┈┈┈┈┈前台通知处理Servlet
  │  │  │
  │  │  └OrderCreateServlet.java┈┈┈┈┈网银示例Servlet
  │  │ 
  │  ├log4j.properties┈┈┈┈┈┈┈┈┈日志配置
  │  │  
  │  └sand_sdk.properties┈┈┈┈┈┈┈┈┈ 配置文件，生产环境需要将配置参数改成对应的值
  │  
  │
  ├lib ┈┈┈┈┈┈┈┈┈┈┈（如果JAVA项目中包含这些架包，则不需要导入）
  │  │
  │  ├commons-codec-1.9.jar
  │  │
  │  ├commons-lang-2.6.jar
  │  │
  │  ├commons-logging-1.2.jar
  │  │
  │  ├fastjson-1.2.7.jar
  │  │
  │  ├httpclient-4.4.1.jar
  │  │
  │  ├httpcore-4.4.1.jar │  
  │  │
  │  ├log4j-1.2.17.jar
  │  │
  │  ├slf4j-api-1.7.9.jar 
  │  │
  │  └slf4j-log4j12-1.5.11.jar			 
  │  
  ├key ┈┈┈┈┈┈┈┈┈┈┈证书文件夹
  │  │
  │  ├merch_private_cert_test.pfx
  │  │
  │  ├sand_public_cert_test.cer 
  │  │
  │  └sand_public_certt.cer	
  │   	     
  ├history.txt┈┈┈┈┈┈┈┈┈修订历史
  │
  └readme.txt ┈┈┈┈┈┈┈┈┈使用说明文本

───────────
 【注意】：

1.【接口规范】
      接口产品规范： 《杉德线上支付接口规范》
      
2.【关于商户号】
      测试商户号可以通过联系技术支持或开放平台上获取
      正式商户号在开会信中获取
  
3.【关于证书】
       商户私钥：
                测试环境：key目录下merch_private_cert_test.pfx  默认密码：123456
                生产环境：找到开户信中两码，去CFCA官网下载获取商户私钥
      杉德公钥：
                测试环境：key目录下sand_public_cert_test.cer  
                生产环境：key目录下sand_public_certt.cer

4.测试过程中的如果遇到疑问或问题您可以：
  1）在开放平台中自助解决，开放平台地址：http://open.sandpay.com.cn/developmentAccess/docs：
  2）通过客服系统联系技术支持。
  
───────────

