<%--
  Created by IntelliJ IDEA.
  User: louis_lai
  Date: 2021/9/8
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>登陆界面</title>
</head>
<body>
    <form action="" method="post">
        <fmt:message key="username"/>：<input type="text" name="username"/><br/>
        <fmt:message key="password"/>：<input type="text" name="password"/><br/>
        <input type="submit" value="<fmt:message key="loginBtn"/>"/>
    </form>
<!--国际化-->
    <a href="toLoginPage?locale=zh_CN">中文</a>|<a href="toLoginPage?locale=en_US">English</ a>
</body>
</html>
