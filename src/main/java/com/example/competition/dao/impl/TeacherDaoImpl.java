package com.example.competition.dao.impl;

import com.example.competition.dao.TeacherDao;
import com.example.competition.entity.Teacher;
import com.example.competition.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl implements TeacherDao {

    private DBConnection dbConnection = null;//定义数据库连接类
    private Connection conn = null;//数据库连接对象
    private PreparedStatement pstmt = null;//数据库操作对象,语句被预编译并且存储在 PreparedStatement 对象中

    public TeacherDaoImpl() throws Exception {
        this.dbConnection = new DBConnection();
        conn = dbConnection.getConnection();
    }

    @Override
    public Teacher getByUserName(String userName) throws SQLException {
        String sql = "select "
                + "id,"
                + "userName,"
                + "password,"
                + "realName,"
                + "phone,"
                + "email,"
                + "createTime from teacher where userName=?";
        this.pstmt = conn.prepareStatement(sql);
        this.pstmt.setString(1, userName);
        ResultSet rs = this.pstmt.executeQuery();
        Teacher teacher = null;
        if (rs.next()) {
            teacher = new Teacher();
            teacher.setId(rs.getInt(1));
            teacher.setUserName(rs.getString(2));
            teacher.setPassword(rs.getString(3));
            teacher.setRealName(rs.getString(4));
            teacher.setPhone(rs.getString(5));
            teacher.setEmail(rs.getString(6));
            teacher.setCreateTime(rs.getDate(7));
        }
        this.pstmt.close();
        return teacher;
    }

    @Override
    public List<Teacher> findAll() throws SQLException {
        List<Teacher> list = new ArrayList<>();
        String sql = "select "
                + "id,"
                + "userName,"
                + "password,"
                + "realName,"
                + "phone,"
                + "email,"
                + "createTime from teacher";
        this.pstmt = conn.prepareStatement(sql);
        ResultSet rs = this.pstmt.executeQuery();
        Teacher teacher = null;
        while (rs.next()) {
            teacher = new Teacher();
            teacher.setId(rs.getInt(1));
            teacher.setUserName(rs.getString(2));
            teacher.setPassword(rs.getString(3));
            teacher.setRealName(rs.getString(4));
            teacher.setPhone(rs.getString(5));
            teacher.setEmail(rs.getString(6));
            teacher.setCreateTime(rs.getDate(7));
            list.add(teacher);
        }
        this.pstmt.close();
        return list;
    }

    @Override
    public void save(Teacher teacher) throws SQLException {
        String sql = "insert into teacher("
        + "userName,"
        + "password,"
        + "realName,"
        + "phone,"
        + "email,"
        + "createTime) value(?,?,?,?,?,?)";
        this.pstmt = conn.prepareStatement(sql);
        this.pstmt.setString(1, teacher.getUserName());
        this.pstmt.setString(2, teacher.getPassword());
        this.pstmt.setString(3, teacher.getRealName());
        this.pstmt.setString(4, teacher.getPhone());
        this.pstmt.setString(5, teacher.getEmail());
        this.pstmt.setDate(6, new Date(teacher.getCreateTime().getTime()));
        this.pstmt.execute();
        this.pstmt.close();
    }

    @Override
    public void deleteById(int id) throws SQLException {
        String sql = "delete from teacher where id=?";
        this.pstmt = conn.prepareStatement(sql);
        this.pstmt.setInt(1, id);
        this.pstmt.execute();
        this.pstmt.close();
    }
}