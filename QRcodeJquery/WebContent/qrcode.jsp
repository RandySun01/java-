<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>生成二维码</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.qrcode.min.js"></script>
</head>
<body>
生成二维码如下：<BR/>
<div id="qrcode"></div>
<script type="text/javascript">
jQuery('#qrcode').qrcode("randySun");
</script>
</body>
</html>