package com.chocho.Dao;

import com.chocho.model.Student;
import com.chocho.util.DbUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

 class BaseDao {
    private DbUtil dbUtil = new DbUtil();

    public void close(){
        dbUtil.closeConnection();
    }

    public ResultSet query(String selectSql, String name){//正常
        try {
            PreparedStatement ps = null;
            if("".equals(name) || name == null){
                ps = dbUtil.getConnection().prepareStatement(selectSql);

            }else {
                ps = dbUtil.getConnection().prepareStatement(selectSql);
                ps.setString(1, name);
            }
            return ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("查询出错!");
            e.printStackTrace();
        }
        return null;
    }

    public void add(Student student, String sql){
        try {
            PreparedStatement ps = dbUtil.getConnection().prepareStatement(sql);
            ps.setInt(1, student.getNumber());
            ps.setString(2, student.getName());
            ps.setString(3, student.getSex());
            ps.setInt(4, student.getAge());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("添加出错！");
            e.printStackTrace();
        }
    }

    public void delete(String deleteSql){
            try {
                PreparedStatement ps = dbUtil.getConnection().prepareStatement(deleteSql);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("删除出错！");
                e.printStackTrace();
            }
    }

    public void edit(String updateSql, String value, String number){
        PreparedStatement ps;
        try {
            ps = dbUtil.getConnection().prepareStatement(updateSql);
            ps.setString(1, value);
            ps.setInt(2, Integer.parseInt(number));
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("修改出错!");
            e.printStackTrace();
        }
    }
}
