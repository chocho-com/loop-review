package com.chocho.Servlet;

import com.chocho.Dao.StudentDao;
import com.chocho.model.Student;

import javax.servlet.http.HttpServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StudentDao dao = new StudentDao();
        String number = request.getParameter("number");

        dao.deleteStudent(number);

        request.setAttribute("number", number);
        request.getRequestDispatcher("/main").forward(request,response);
    }
}
