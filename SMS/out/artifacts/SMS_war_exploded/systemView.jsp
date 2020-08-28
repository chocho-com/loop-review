<%@ page import="com.chocho.model.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Date" %>
<%--<%@taglib prefix="SimpleTagLibrary" uri="http://tomcat.apache.org/jsp2-example-taglib" %>&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: 山鬼名夏--%>
<%--  Date: 2019/8/31--%>
<%--  Time: 20:32--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息管理系统 后台管理</title>
</head>
<body>

<h1><b>学生信息管理系统</b></h1>
<hr>

<a href="addView.jsp" target=blank>添加</a>
<form method="post" action="main">
    <input type="text" placeholder="请输入姓名" name="select">
    <input type="submit" name="submit" value="开始查询" >
</form>
<%=new Date()%>
<br><br><br>

<table width="960px" border="1" align="center">
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th colspan="2">操作选项</th>
    </tr>
    <%
        List<Student> studentList = (List<Student>) request.getAttribute("studentList");
        Iterator<Student> it = studentList.iterator();
        while(it.hasNext()){
            Student student = it.next();
    %>
    <tr>
        <th><%=student.getNumber()%></th>
        <th><%=student.getName()%></th>
        <th><%=student.getSex()%></th>
        <th><%=student.getAge()%></th>
        <th><a href="deleteServlet?number=<%=student.getNumber()%>" target=blank id="aBtn">删除</a></th>
        <th><a href="editView.jsp?number=<%=student.getNumber()%>" target=blank>修改</a></th>
    </tr>
    <script type="text/javascript">
        $("#aBtn").click(function(){
            $.get("deleteServlet", "number=<%=student.getNumber()%>",
                function (cho) {
                alert(cho);
            }, html);
            return false;
        })
    </script>
    <%
        }
    %>
</table>
</body>
</html>
