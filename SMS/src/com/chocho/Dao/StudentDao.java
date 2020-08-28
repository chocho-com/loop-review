package com.chocho.Dao;

import com.chocho.model.Student;

import java.sql.*;
import java.util.*;

public class StudentDao extends BaseDao{
    public List<Student> queryStudent(String name){//查询学生信息，可按照名字模糊查找
        String sql = "";

        if(name.length() == 0){
            sql = "select * from t_student";
        }else {//null
            sql = "select * from t_student where name like '%' + ? + '%'";
        }

        ResultSet results = query(sql, name);
        List<Student> studentlist = new ArrayList<>();
        try {
            while(results.next()){
                Student student = new Student();
                student.setNumber(results.getInt("id"));
                student.setName(results.getString("name"));
                student.setSex(results.getString("sex"));
                student.setAge(results.getInt("age"));
                studentlist.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentlist;
    }

    public void addStudent(Student student){//添加指定学生信息
        String sql = "insert into t_student values(?,?,?,?)";
        add(student, sql);
    }

    public void deleteStudent(String number){//按学号删除
        String sql = "delete from t_student where id ="+ number;
        delete(sql);
    }

    public void editStudent(String way, String value, String number){//按照修改的方法修改对应的值
        String updateSql = "";

        updateSql += "update t_student set " + way + " = ? where id = ?";
        edit(updateSql, value, number);
    }
}
