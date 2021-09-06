<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: louis_lai
  Date: 2021/9/4
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>添加员工</title>
</head>
<%--<body>--%>
<%--<form action="/toAddPage" method="post">--%>
<%--    姓名: <input type="text" name="name"><br/>--%>
<%--    邮箱: <input type="text" name="email"><br/>--%>
<%--    性别: 男<input type="radio" name="gender" value="1">  女<input type="radio" name="gender" value="0"><br/>--%>
<%--    部门id: <select name="departmentId">--%>
<%--                <c:forEach  items="${departments}" var="department">--%>
<%--                    <option value="${department.departmentId}">${department.departmentId}</option>--%>
<%--                </c:forEach>--%>
<%--            </select><br/>--%>
<%--    部门: <select name="departmentName">--%>
<%--                <c:forEach items="${departments}" var="department">--%>
<%--                    <option value="${department.departmentName}">${department.departmentName}</option>--%>
<%--                </c:forEach>--%>
<%--         </select><br/>--%>
<%--    <input type="submit" value="添加">--%>
<%--</form>--%>
<!--Springmvc表单标签-->
<%
        pageContext.setAttribute("ctp",request.getContextPath());
%>
<form:form action="${ctp}/emp" method="post" modelAttribute="employee">
        ID: <form:input path="employeeId"/><br/>
        姓名: <form:input path="name"/><br/>
        邮箱: <form:input path="email"/><br/>
        性别: 男<form:radiobutton path="gender" value="1"/>  女<form:radiobutton path="gender" value="0"/><br/>
        部门id: <form:select path="departmentId" items="${departments}" itemLabel="departmentId" itemValue="departmentId"/><br/>
        部门: <form:select path="departmentName" items="${departments}" itemLabel="departmentName" itemValue="departmentName"/><br/>
        <input type="submit" value="添加">
</form:form>
</body>
</html>
