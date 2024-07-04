package com.example.competition.dao.impl;

import com.example.competition.dao.NoticeDao;
import com.example.competition.entity.Notice;
import com.example.competition.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoticeDaoImpl implements NoticeDao {

    private DBConnection dbConnection = null;//定义数据库连接类
    private Connection conn = null;//数据库连接对象
    private PreparedStatement pstmt = null;//数据库操作对象,语句被预编译并且存储在 PreparedStatement 对象中

    public NoticeDaoImpl() throws Exception {
        this.dbConnection = new DBConnection();
        conn = dbConnection.getConnection();
    }

    public NoticeDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Notice> findAll(String title) throws SQLException {
        List<Notice> list = new ArrayList<Notice>();//定义集合
        String sql = "select * from notice";
        if (title != null && title != "") {
            sql = "select * from notice where title like ?";
            this.pstmt.setString(1, "%" + title + "%");
        }

        this.pstmt = this.conn.prepareStatement(sql);
        ResultSet rs = this.pstmt.executeQuery();//执行查询语句
        Notice notice = null;
        while (rs.next()) {
            notice = new Notice();
            notice.setId(rs.getInt(1));
            notice.setTitle(rs.getString(2));
            notice.setContent(rs.getString(3));
            notice.setImg(rs.getString(4));
            notice.setCreateTime(rs.getDate(5));
            list.add(notice);//向集合中添加product对象
        }
        this.pstmt.close();
        return list;
    }

    @Override
    public List<Notice> findByPage(String title, int page, int pageSize) throws SQLException {
        List<Notice> list = new ArrayList<Notice>();//定义集合
        String sql = "select * from notice limit ?,?";
        if (title != null && title != "") {
            sql = "select * from notice where title like ? limit ?,?";
            this.pstmt.setString(1, "%" + title + "%");
            this.pstmt.setInt(2, page);
            this.pstmt.setInt(3, pageSize);
        } else {
            this.pstmt.setInt(1, page);
            this.pstmt.setInt(2, pageSize);
        }

        this.pstmt = this.conn.prepareStatement(sql);
        ResultSet rs = this.pstmt.executeQuery();//执行查询语句
        Notice notice = null;
        while (rs.next()) {
            notice = new Notice();
            notice.setId(rs.getInt(1));
            notice.setTitle(rs.getString(2));
            notice.setContent(rs.getString(3));
            notice.setImg(rs.getString(4));
            notice.setCreateTime(rs.getDate(4));
            list.add(notice);//向集合中添加product对象
        }
        this.pstmt.close();
        return list;
    }

    @Override
    public void save(Notice notice) throws SQLException {
        String sql = "insert into notice(" +
                "title,content,img,createTime) value(?,?,?,?)";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1, notice.getTitle());
        this.pstmt.setString(2, notice.getContent());
        this.pstmt.setString(3, notice.getImg());
        this.pstmt.setDate(4, new Date(notice.getCreateTime().getTime()));
        this.pstmt.execute();
        this.pstmt.close();
    }

    @Override
    public void deleteById(Integer id) throws SQLException {
        String sql = "delete from notice where id=?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setInt(1, id);
        this.pstmt.execute();
        this.pstmt.close();
    }
}