<%--
  Created by IntelliJ IDEA.
  User: 山鬼名夏
  Date: 2019/8/31
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生信息</title>
</head>
<body>
<div style="width:100%;text-align:center">
    <br><br><br><br>
    <form method="post" action="addServlet">
        学号：
        <input type="text" name="Number" placeholder="学号"><br>
        姓名：
        <input type="text" name="Name" placeholder="姓名"><br>
        性别：
        <input type="radio" name="Sex" value="male">男
        <input type="radio" name="Sex" value="female">女<br>
        年龄：
        <input type="text" name="Age" placeholder="年龄"><br><br>
        <pre>
            <input type="submit" value="添加" height="100px" name="add">
        </pre>
    </form>
    </div>
</body>
</html>
