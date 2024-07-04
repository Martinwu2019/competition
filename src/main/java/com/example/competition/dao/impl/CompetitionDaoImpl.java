package com.example.competition.dao.impl;

import com.example.competition.dao.AdminDao;
import com.example.competition.dao.CompetitionDao;
import com.example.competition.entity.Competition;
import com.example.competition.entity.Notice;
import com.example.competition.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompetitionDaoImpl implements CompetitionDao {
    private DBConnection dbConnection = null;//定义数据库连接类
    private Connection conn = null;//数据库连接对象
    private PreparedStatement pstmt = null;//数据库操作对象,语句被预编译并且存储在 PreparedStatement 对象中

    public CompetitionDaoImpl() throws Exception {
        this.dbConnection = new DBConnection();
        conn = dbConnection.getConnection();
    }

    public CompetitionDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Competition> findAll() throws SQLException {
        List<Competition> list = new ArrayList<Competition>();//定义集合
        String sql = "select c.id," +
                "c.title," +
                "c.content," +
                "c.teamRegTimeFm," +
                "c.teamRegTimeTo," +
                "c.worksTimeFm," +
                "c.worksTimeTo," +
                "c.checkTimeFm," +
                "c.checkTimeTo," +
                "c.createTime " +
                "from competition c";
        this.pstmt = this.conn.prepareStatement(sql);
        ResultSet rs = this.pstmt.executeQuery();//执行查询语句
        Competition competition = null;
        while (rs.next()) {
            competition = new Competition();
            competition.setId(rs.getInt(1));
            competition.setTitle(rs.getString(2));
            competition.setContent(rs.getString(3));
            competition.setTeamRegTimeFm(rs.getDate(4));
            competition.setTeamRegTimeTo(rs.getDate(5));
            competition.setWorksTimeFm(rs.getDate(6));
            competition.setWorksTimeTo(rs.getDate(7));
            competition.setCheckTimeFm(rs.getDate(8));
            competition.setCheckTimeTo(rs.getDate(9));
            competition.setCreateTime(rs.getDate(10));
            list.add(competition);//向集合中添加product对象
        }
        this.pstmt.close();
        return list;
    }

    @Override
    public Competition findById(Integer competitionId) throws SQLException {
        String sql = "select c.id," +
                "c.title," +
                "c.content," +
                "c.teamRegTimeFm," +
                "c.teamRegTimeTo," +
                "c.worksTimeFm," +
                "c.worksTimeTo," +
                "c.checkTimeFm," +
                "c.checkTimeTo," +
                "c.createTime " +
                "from competition c where c.id=?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setInt(1, competitionId);
        ResultSet rs = this.pstmt.executeQuery();//执行查询语句
        Competition competition = null;
        if (rs.next()) {
            competition = new Competition();
            competition.setId(rs.getInt(1));
            competition.setTitle(rs.getString(2));
            competition.setContent(rs.getString(3));
            competition.setTeamRegTimeFm(rs.getDate(4));
            competition.setTeamRegTimeTo(rs.getDate(5));
            competition.setWorksTimeFm(rs.getDate(6));
            competition.setWorksTimeTo(rs.getDate(7));
            competition.setCheckTimeFm(rs.getDate(8));
            competition.setCheckTimeTo(rs.getDate(9));
            competition.setCreateTime(rs.getDate(10));
        }
        return competition;
    }


    @Override
    public void save(Competition competition) throws SQLException {
        String sql = "insert into competition("
        + "title,"
        + "content,"
        + "teamRegTimeFm,"
        + "teamRegTimeTo,"
        + "worksTimeFm,"
        + "worksTimeTo,"
        + "checkTimeFm,"
        + "checkTimeTo,"
        + "createTime) value(?,?,?,?,?,?,?,?,?)";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1, competition.getTitle());
        this.pstmt.setString(2, competition.getContent());
        this.pstmt.setDate(3, new Date(competition.getTeamRegTimeFm().getTime()));
        this.pstmt.setDate(4, new Date(competition.getTeamRegTimeTo().getTime()));
        this.pstmt.setDate(5, new Date(competition.getWorksTimeFm().getTime()));
        this.pstmt.setDate(6, new Date(competition.getWorksTimeTo().getTime()));
        this.pstmt.setDate(7, new Date(competition.getCheckTimeFm().getTime()));
        this.pstmt.setDate(8, new Date(competition.getCheckTimeTo().getTime()));
        this.pstmt.setDate(9, new Date(competition.getCreateTime().getTime()));
        this.pstmt.execute();
        this.pstmt.close();
    }

    @Override
    public void deleteById(int id) throws SQLException {
        String sql = "delete from competition where id=?";
        this.pstmt = conn.prepareStatement(sql);
        this.pstmt.setInt(1, id);
        this.pstmt.execute();
        this.pstmt.close();
    }
}