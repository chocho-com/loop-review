package com.chocho.Servlet;

import com.chocho.Dao.StudentDao;
import com.chocho.model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        List<Student> studentList = new ArrayList<>();
        StudentDao dao = new StudentDao();
        String name;
        String _name = request.getParameter("select");
        if("".equals(_name) || _name == null){
            name = "";
        }else {
            name = _name;
        }
        studentList = dao.queryStudent(name);
        request.setAttribute("studentList", studentList);
        request.getRequestDispatcher("systemView.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
