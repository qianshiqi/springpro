<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@page import="java.util.Enumeration,java.util.Map" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.Iterator" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/scripts/paymentjs.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/scripts/jquery-1.7.2.min.js"></script>
</head>
<body>
<script> b

function wap_pay() {
    var responseText = $("#credential").text();
    console.log(responseText);
    paymentjs.createPayment(responseText, function (result, err) {
        console.log(result);
        console.log(err.msg);
        console.log(err.extra);
    });


}
</script>
<div style="display: none">

    <%
        String credential = (String) request.getAttribute("JWP_ATTR");

    %>
    <p id="credential"><%=credential%>
    </p>
</div>
</body>

<script>
    window.onload = function () {
        wap_pay();
    };
</script>
</html>
