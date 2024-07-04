package com.example.competition.dao.impl;

import com.example.competition.dao.TeamMemberDao;
import com.example.competition.entity.TeamMember;
import com.example.competition.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeamMemberDaoImpl implements TeamMemberDao {
    private DBConnection dbConnection = null;//定义数据库连接类
    private Connection conn = null;//数据库连接对象
    private PreparedStatement pstmt = null;//数据库操作对象,语句被预编译并且存储在 PreparedStatement 对象中

    public TeamMemberDaoImpl() throws Exception {
        this.dbConnection = new DBConnection();
        conn = dbConnection.getConnection();
    }

    @Override
    public TeamMember getByStuId(Integer stuId, Integer competitionId) throws SQLException {
        TeamMember teamMember = null;
        String sql = "select id,teamId,studentId,competitionId " +
                "from teammember where studentId=? and competitionId=?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setInt(1,stuId);
        this.pstmt.setInt(2,competitionId);
        ResultSet rs = this.pstmt.executeQuery();
        if (rs.next()){
            teamMember = new TeamMember();
            teamMember.setId(rs.getInt(1));
            teamMember.setTeamId(rs.getInt(2));
            teamMember.setStudentId(rs.getInt(3));
            teamMember.setCompetitionId(rs.getInt(4));
        }
        this.pstmt.close();
        return teamMember;//若查询不到则就返回空。
    }

    @Override
    public List<TeamMember> getByStuId(Integer stuId) throws SQLException {
        List<TeamMember> list = new ArrayList<>();
        String sql = "select id,teamId,studentId,competitionId " +
                "from teammember where studentId=?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setInt(1,stuId);
        ResultSet rs = this.pstmt.executeQuery();
        while (rs.next()){
            TeamMember teamMember = new TeamMember();
            teamMember.setId(rs.getInt(1));
            teamMember.setTeamId(rs.getInt(2));
            teamMember.setStudentId(rs.getInt(3));
            teamMember.setCompetitionId(rs.getInt(4));
            list.add(teamMember);
        }
        this.pstmt.close();
        return list;//若查询不到则就返回空。
    }

    @Override
    public List<TeamMember> getByComIdAndTeamId(Integer comId, Integer teamId) throws SQLException {
        List<TeamMember> list = new ArrayList<>();
        String sql = "select id,teamId,studentId,competitionId " +
                "from teammember where competitionId=? and teamId=?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setInt(1,comId);
        this.pstmt.setInt(2,teamId);
        ResultSet rs = this.pstmt.executeQuery();
        while (rs.next()){
            TeamMember teamMember = new TeamMember();
            teamMember.setId(rs.getInt(1));
            teamMember.setTeamId(rs.getInt(2));
            teamMember.setStudentId(rs.getInt(3));
            teamMember.setCompetitionId(rs.getInt(4));
            list.add(teamMember);
        }
        this.pstmt.close();
        return list;//若查询不到则就返回空。
    }
    @Override
    public void save(TeamMember teamMember) throws SQLException {
        String sql = "insert into teammember(" +
                "teamId," +
                "studentId," +
                "competitionId) value (?,?,?)";
        this.pstmt = this.conn.prepareStatement(sql);//实例化prepareStatement对象
        this.pstmt.setInt(1,teamMember.getTeamId());
        this.pstmt.setInt(2,teamMember.getStudentId());
        this.pstmt.setInt(3,teamMember.getCompetitionId());
        if (this.pstmt.executeUpdate() == 0){
            throw new SQLException("Creating user failed, no rows affected.");
        }
    }

    @Override
    public void deleteByStuIdAndTeam(Integer sId, Integer teamId) throws SQLException {
        String sql;
        if (sId == null) {
            sql = "delete from teammember where teamId=?";
            this.pstmt = this.conn.prepareStatement(sql);//实例化prepareStatement对象
            this.pstmt.setInt(1,teamId);
        } else {
            sql = "delete from teammember where studentId=? and teamId=?";
            this.pstmt = this.conn.prepareStatement(sql);//实例化prepareStatement对象
            this.pstmt.setInt(1,sId);
            this.pstmt.setInt(2,teamId);
        }
        this.pstmt.execute();
    }
}