<%--
  Created by IntelliJ IDEA.
  User: louis_lai
  Date: 2021/9/4
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>员工页面</title>
    <script type="text/javascript" src="static/jquery-1.9.1.min.js"></script>
</head>
<body>
<h1>员工列表
</h1>
<table border="1px" cellspacing="0" cellpadding="5">
    <tr>
        <th>员工id</th>
        <th>姓名</th>
        <th>邮箱</th>
        <th>性别</th>
        <th>部门id</th>
        <th>部门</th>
        <th>更新</th>
        <th>删除</th>
    </tr>
    <c:forEach items="${employees}" var="emp">
        <tr>
            <td>${emp.employeeId}</td>
            <td>${emp.name}</td>
            <td>${emp.email}</td>
            <td>${emp.gender==0?"女":"男"}</td>
            <td>${emp.departmentId}</td>
            <td>${emp.departmentName}</td>
            <td><a href="employee/${emp.employeeId}">EDIT</a></td>
            <td><a class="deleteEmployee" href="employee/${emp.employeeId}">DELETE</a></td>
        </tr>
    </c:forEach>
</table>

<a href="toAddPage">添加员工</a>
<form action="employee/${emp.employeeId}" method="post" id="deleteForm">
    <input type="hidden" name="_method" value="DELETE">
</form>
<script type="text/javascript">
    $(function(){
        $(".deleteEmployee").click(function(){
            if(confirm("确定删除"+$(this).parent().parent().find("td:eq(1)").text())){
                $("#deleteForm").attr("action",this.href);
                $("#deleteForm").submit();
            }
            return false;
        })
    })
</script>
</body>
</html>
