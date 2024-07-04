package com.example.competition.dao.impl;

import com.example.competition.dao.WorksDao;
import com.example.competition.entity.Works;
import com.example.competition.utils.DBConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WorksDaoImpl implements WorksDao {
    private DBConnection dbConnection = null;//定义数据库连接类
    private Connection conn = null;//数据库连接对象
    private PreparedStatement pstmt = null;//数据库操作对象,语句被预编译并且存储在 PreparedStatement 对象中

    public WorksDaoImpl() throws Exception {
        this.dbConnection = new DBConnection();
        conn = dbConnection.getConnection();
    }
    @Override
    public void save(Works works) throws SQLException {
        String sql = "insert into works("
         + " worksName, "
         + " category, "
         + " subclass, "
         + " worksCode, "
         + " filePath, "
         + " audit, "
         + " createTime, "
         + " teamId) value(?,?,?,?,?,?,?,?)";
        this.pstmt = this.conn.prepareStatement(sql);//实例化prepareStatement对象
        this.pstmt.setString(1,works.getWorksName());
        this.pstmt.setString(2,works.getCategory());
        this.pstmt.setString(3,works.getSubclass());
        this.pstmt.setString(4,works.getWorksCode());
        this.pstmt.setString(5,works.getFilePath());
        this.pstmt.setString(6,works.getAudit());
        this.pstmt.setDate(7,new Date(works.getCreateTime().getTime()));
        this.pstmt.setInt(8,works.getTeamId());
        if (this.pstmt.executeUpdate() == 0){
            throw new SQLException("Creating user failed, no rows affected.");
        }
    }
}