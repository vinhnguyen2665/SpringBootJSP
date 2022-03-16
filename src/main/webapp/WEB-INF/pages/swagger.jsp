<%@ page import="com.vinhnq.common.URLConst" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
    String redirectURL = "." + URLConst.DASHBOARD.HOME;
    response.sendRedirect(redirectURL);
%>
</head>
<body>
	rediect to swagger
</body>
</html>