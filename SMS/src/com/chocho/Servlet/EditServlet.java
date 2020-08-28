package com.chocho.Servlet;

import com.chocho.Dao.StudentDao;
import com.chocho.model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        StudentDao dao = new StudentDao();
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String number = request.getParameter("number");
        String name = request.getParameter("Name");
        String sex = request.getParameter("Sex");
        String age = request.getParameter("Age");

        if("".equals(name) == false && name != null){
            dao.editStudent("name", name, number);
        }else if("".equals(sex) == false && sex != null){
            dao.editStudent("sex", sex, number);
        }else if("".equals(age) == false && age != null){
            dao.editStudent("age", age, number);
        }

        request.getRequestDispatcher("/main").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
