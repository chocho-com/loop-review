package com.chocho.Servlet;

import com.chocho.Dao.StudentDao;
import com.chocho.model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        StudentDao dao = new StudentDao();
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        int number = Integer.parseInt(request.getParameter("Number"));
        String name = request.getParameter("Name");
        String sex = request.getParameter("Sex");
        int age = Integer.parseInt(request.getParameter("Age"));

        //转化性别为中文字符串
        if("female".equals(sex)){
            sex = "女";
        }else{
            sex = "男";
        }
        Student student = new Student();
        student.setNumber(number);
        student.setName(name);
        student.setSex(sex);
        student.setAge(age);

        dao.addStudent(student);

        request.setAttribute("student", student);
        request.getRequestDispatcher("/main").forward(request, response);
    }
}
