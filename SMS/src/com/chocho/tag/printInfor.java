package com.chocho.tag;

import com.chocho.Dao.StudentDao;
import com.chocho.model.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class printInfor extends HttpServlet{

    public static void show(HttpServletRequest request, HttpServletResponse response)
    {
        StudentDao studentDao = new StudentDao();
        List<Student> studentList = studentDao.queryStudent("");
        Iterator<Student> it = studentList.iterator();
        HttpSession s = request.getSession();
        s.setAttribute("studentList", studentList);
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (it.hasNext()) {
            Student student = it.next();
            out.println("<tr>");
            out.println("<th>" + student.getNumber() + "</th>");
            out.println("<th>" + student.getName() + "</th>");
            out.println("<th>" + student.getSex() + "</th>");
            out.println("<th>" + student.getAge() + "</th>");
            out.println("<th><a href=\"deleteServlet?number=" + student.getNumber() + "\" target=blank>删除</a></th>");
            out.println("<th><a href=\"editView.jsp?number=" + student.getNumber() + "\" target=blank>修改</a></th>");
            out.println("</tr>");
        }
    }

    public Student getStudent(HttpServletRequest request){
        HttpSession s = request.getSession();
        List<Student> studentList = (ArrayList<Student>) s.getAttribute("studentList");
        int number = Integer.parseInt(request.getParameter("number"));
        Student student = new Student();

        Iterator<Student> it = studentList.iterator();
        while(it.hasNext()){
            Student stu = it.next();
            if(number == stu.getNumber()){
                student = stu;
                break;
            }
        }

        return student;
    }

    public static int getNumber(HttpServletRequest request){
        printInfor p = new printInfor();

        return p.getStudent(request).getNumber();
    }

    public static String getName(HttpServletRequest request){
        printInfor p = new printInfor();

        return p.getStudent(request).getName();
    }

    public static String getSex(HttpServletRequest request){
        printInfor p = new printInfor();

        return p.getStudent(request).getSex();
    }

    public static int getAge(HttpServletRequest request){
        printInfor p = new printInfor();

        return p.getStudent(request).getAge();
    }

}
