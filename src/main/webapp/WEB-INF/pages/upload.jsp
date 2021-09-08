<%--
  Created by IntelliJ IDEA.
  User: louis_lai
  Date: 2021/9/8
  Time: 1:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>文件上传</title>
    <%
        pageContext.setAttribute("cpt",request.getContextPath());
    %>
</head>
<body>
${msg}
<form action="${cpt}/uploadFile" method="post" enctype="multipart/form-data">
    用户头像:<input type="file" name="headerimg"><br/>
    用户名:<input type="input" name="username"/><br/>
    <input type="submit" value="单文件上传"/>
</form>

<from action="${cpt}/uploadFiles" method="post" enctype="multipart/form-data">
    美女图1：<input type="file" name="img"><br/>
    美女图2：<input type="file" name="img"><br/>
    <input type="submit" value="多文件上传"/>
</from>
</body>
</html>
