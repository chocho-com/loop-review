<%@ page import="com.chocho.model.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@taglib prefix="SimpleTagLibrary" uri="http://tomcat.apache.org/jsp2-example-taglib" %><%--
  Created by IntelliJ IDEA.
  User: 山鬼名夏
  Date: 2019/9/4
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改学生信息</title>
</head>
<body>
<div style="width:100%;text-align:center">
    <h1 style="color:darkgrey">请选择需要修改的一项进行修改</h1>
    <br><br><br><br>
    <form method="post" action="editServlet?number=${SimpleTagLibrary:getNumber(pageContext.request)}">
        姓名：
        <input type="text" name="Name  " placeholder="${SimpleTagLibrary:getName(pageContext.request)}"><br>
        性别：
        <input type="text" name="Sex" placeholder="${SimpleTagLibrary:getSex(pageContext.request)}"><br>
        年龄：
        <input type="text" name="Age" placeholder="${SimpleTagLibrary:getAge(pageContext.request)}"><br><br>
        <pre>
            <input type="submit" value="修改" height="100px" name="edit">
        </pre>
    </form>
</div>
</body>
</html>
