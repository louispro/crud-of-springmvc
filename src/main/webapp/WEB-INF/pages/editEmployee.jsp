<%--
  Created by IntelliJ IDEA.
  User: louis_lai
  Date: 2021/9/5
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>员工修改页面</title>
</head>
<body>
<h1>修改员工信息</h1>
<from:form action="" modelAttribute="employee">
    <input type="hidden" name="_method" value="PUT"/>
    <input type="hidden" name="id" value="${employee.employeeId}"/>
    姓名：<form:input path="name"/><br/>
    邮箱：<form:input path="email"/><br/>
    性别： 男<form:radiobutton path="gender" value="1"/> 女<form:radiobutton path="gender" value="0"/><br/>
    部门Id：<form:select path="departmentId" items="${departments}" itemLabel="departmentId" itemValue="departmentId"/><br/>
    部门：<form:select path="departmentName" items="${departments}" itemLabel="departmentName" itemValue="departmentName"/><br/>
    <input type="submit" value="提交"/>
</from:form>
</body>
</html>
