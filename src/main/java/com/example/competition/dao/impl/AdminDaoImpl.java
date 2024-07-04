package com.example.competition.dao.impl;

import com.example.competition.dao.AdminDao;
import com.example.competition.entity.Admin;
import com.example.competition.entity.Teacher;
import com.example.competition.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {

    private DBConnection dbConnection = null;//定义数据库连接类
    private Connection conn = null;//数据库连接对象
    private PreparedStatement pstmt = null;//数据库操作对象,语句被预编译并且存储在 PreparedStatement 对象中

    public AdminDaoImpl() throws Exception {
        this.dbConnection = new DBConnection();
        conn = dbConnection.getConnection();
    }

    @Override
    public Admin getByUserName(String userName) throws SQLException {
        String sql = "select "
                + "id,"
                + "userName,"
                + "password from admin where userName=?";
        this.pstmt = conn.prepareStatement(sql);
        this.pstmt.setString(1, userName);
        ResultSet rs = this.pstmt.executeQuery();
        Admin admin = null;
        if (rs.next()) {
            admin = new Admin();
            admin.setId(rs.getInt(1));
            admin.setUserName(rs.getString(2));
            admin.setPassword(rs.getString(3));
        }
        this.pstmt.close();
        return admin;
    }
}