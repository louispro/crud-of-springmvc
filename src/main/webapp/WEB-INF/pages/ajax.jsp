<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: louis_lai
  Date: 2021/9/7
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
  <title>ajax获取所有员工</title>
  <script type="text/javascript" src="static/jquery-1.9.1.min.js"></script>

</head>
<body>
<%  pageContext.setAttribute("cpt",request.getContextPath());%>
<%= new Date()%>
  <a href="employeesByAjax">ajax获取所有员工</a>
  <a class="json" href="getJson_1">发送json数据</a>
  <form action="${cpt}/getJson" method="post" enctype="multipart/form-data">
    <input name="employeeId"/>
    <input name="name" value="tomcat"/>
    <input type="file" name="file"/>
    <input type="submit" value="发送json数据"/>
  </form>
  <div>
    <table border="1px" cellspacing="0" cellpadding="5">
      <tr>
        <th>员工id</th>
        <th>姓名</th>
        <th>邮箱</th>
        <th>性别</th>
        <th>部门id</th>
        <th>部门</th>
      </tr>
    </table>
  </div>
  <script type="text/javascript">
    $("a:first").click(function(){
      //发送ajax请求
      $.ajax({
        url:"${cpt}/employeesByAjax",
        type:"GET",
        success:function(data){
          $.each(data,function (){
            var gender = this.gender==1?"男":"女"
              var element = "<tr>" +
                      "<td>"+this.employeeId+"</td>" +
                      "<td>"+this.name+"</td>" +
                      "<td>"+this.email+"</td>" +
                      "<td>"+gender+"</td>" +
                      "<td>"+this.departmentId+"</td>" +
                      "<td>"+this.departmentName+"</td>" +
                      "</tr>"
              $("table").append(element)
          })
        }
      })
      return false
    })

    $(".json").click(function(){
      var emp = {
        employeeId:1020,
        name:"louis"
      }
      var empStr = JSON.stringify(emp)
      $.ajax({
        url:"${cpt}/getJson_1",
        type:"POST",
        data:empStr,
        contentType:"application/json",
        success:function(data){
          alert(data)
        }
      })
      return false
    })
  </script>
</body>
</html>
