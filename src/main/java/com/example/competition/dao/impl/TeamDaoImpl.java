package com.example.competition.dao.impl;

import com.example.competition.dao.TeamDao;
import com.example.competition.entity.Team;
import com.example.competition.entity.TeamMember;
import com.example.competition.utils.DBConnection;
import org.apache.commons.lang3.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeamDaoImpl implements TeamDao {
    private DBConnection dbConnection = null;//定义数据库连接类
    private Connection conn = null;//数据库连接对象
    private PreparedStatement pstmt = null;//数据库操作对象,语句被预编译并且存储在 PreparedStatement 对象中

    public TeamDaoImpl() throws Exception {
        this.dbConnection = new DBConnection();
        conn = dbConnection.getConnection();
    }

    @Override
    public Team getById(Integer teamId) throws SQLException {
        Team team = null;
        String sql = "select " +
                "id," +
                "teamName," +
                "loginName," +
                "password," +
                "teacherId," +
                "teacherName," +
                "teacherId2," +
                "teacherName2," +
                "studentId," +
                "studentName," +
                "upload," +
                "audit," +
                "createTime," +
                "competitionId," +
                "checkTeacherId, " +
                "worksName," +
                "category," +
                "subclass," +
                "worksCode " +
                "from team where id=?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setInt(1, teamId);//设置产品编号
        ResultSet rs = this.pstmt.executeQuery();
        if (rs.next()) {
            team = new Team();
            team.setId(rs.getInt(1));
            team.setTeamName(rs.getString(2));
            team.setLoginName(rs.getString(3));
            team.setPassword(rs.getString(4));
            team.setTeacherId(rs.getInt(5));
            team.setTeacherName(rs.getString(6));
            team.setTeacherId2(rs.getInt(7));
            team.setTeacherName2(rs.getString(8));
            team.setStudentId(rs.getInt(9));
            team.setStudentName(rs.getString(10));
            team.setUpload(rs.getString(11));
            team.setAudit(rs.getString(12));
            team.setCreateTime(rs.getDate(13));
            team.setCompetitionId(rs.getInt(14));
            team.setCheckTeacherId(rs.getInt(15));
            team.setWorksName(rs.getString(16));
            team.setCategory(rs.getString(17));
            team.setSubclass(rs.getString(18));
            team.setWorksCode(rs.getString(19));
        }
        this.pstmt.close();
        return team;
    }

    @Override
    public Team save(Team team) throws SQLException {
        String sql = "insert into team(" +
                "teamName," +
                "loginName," +
                "password," +
                "teacherName," +
                "teacherName2," +
                "studentId," +
                "studentName," +
                "createTime," +
                "competitionId) value (?,?,?,?,?,?,?,?,?)";
        this.pstmt = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//实例化prepareStatement对象
        this.pstmt.setString(1, team.getTeamName());
        this.pstmt.setString(2, team.getLoginName());
        this.pstmt.setString(3, team.getPassword());
        this.pstmt.setString(4, team.getTeacherName());
        this.pstmt.setString(5, team.getTeacherName2());
        this.pstmt.setInt(6, team.getStudentId());
        this.pstmt.setString(7, team.getStudentName());
        this.pstmt.setDate(8, new Date(team.getCreateTime().getTime()));
        this.pstmt.setInt(9, team.getCompetitionId());
        if (this.pstmt.executeUpdate() == 0) {
            throw new SQLException("Creating user failed, no rows affected.");
        }
        try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                System.out.println("Inserted record's ID: " + id);
                team.setId(id);
            } else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        }
        this.pstmt.close();//关闭prepareStatement操作
        return team;
    }

    @Override
    public void deleteByTeamId(Integer teamId) throws SQLException {
        String sql = "delete from team where id=?";
        this.pstmt = this.conn.prepareStatement(sql);//实例化prepareStatement对象
        this.pstmt.setInt(1, teamId);
        this.pstmt.execute();
    }

    @Override
    public void updateById(Team team) throws SQLException {
        StringBuilder sql = new StringBuilder("update team set ");
        int flag = 0;
        if (StringUtils.isNotBlank(team.getTeamName())) {
            sql.append("teamName='").append(team.getTeamName()).append("'");
            flag++;
        }
        if (StringUtils.isNotBlank(team.getLoginName())) {
            if (flag > 0) {
                sql.append(",");
            }
            sql.append("loginName='").append(team.getLoginName()).append("'");
            flag++;
        }
        if (StringUtils.isNotBlank(team.getPassword())) {
            if (flag > 0) {
                sql.append(",");
            }
            sql.append("password='").append(team.getPassword()).append("'");
            flag++;
        }
        if (team.getTeacherId() != null) {
            if (flag > 0) {
                sql.append(",");
            }
            sql.append("teacherId=").append(team.getTeacherId());
            flag++;
        }
        if (StringUtils.isNotBlank(team.getTeacherName())) {
            if (flag > 0) {
                sql.append(",");
            }
            sql.append("teacherName='").append(team.getTeacherName()).append("'");
            flag++;
        }
        if (team.getTeacherId2() != null) {
            if (flag > 0) {
                sql.append(",");
            }
            sql.append("teacherId2=").append(team.getTeacherId2());
            flag++;
        }
        if (StringUtils.isNotBlank(team.getTeacherName2())) {
            if (flag > 0) {
                sql.append(",");
            }
            sql.append("teacherName2='").append(team.getTeacherName2()).append("'");
            flag++;
        }
        if (team.getStudentId() != null) {
            if (flag > 0) {
                sql.append(",");
            }
            sql.append("studentId=").append(team.getStudentId());
            flag++;
        }
        if (StringUtils.isNotBlank(team.getStudentName())) {
            if (flag > 0) {
                sql.append(",");
            }
            sql.append("studentName='").append(team.getStudentName()).append("'");
            flag++;
        }
        if (StringUtils.isNotBlank(team.getUpload())) {
            if (flag > 0) {
                sql.append(",");
            }
            sql.append("upload='").append(team.getUpload()).append("'");
            flag++;
        }
        if (StringUtils.isNotBlank(team.getAudit())) {
            if (flag > 0) {
                sql.append(",");
            }
            sql.append("audit='").append(team.getAudit()).append("'");
            flag++;
        }
        if (team.getCheckTeacherId() != null) {
            if (flag > 0) {
                sql.append(",");
            }
            sql.append("checkTeacherId=").append(team.getCheckTeacherId());
            flag++;
        }

        if (StringUtils.isNotBlank(team.getCategory())) {
            if (flag > 0) {
                sql.append(",");
            }
            sql.append("category='").append(team.getCategory()).append("'");
            flag++;
        }

        if (StringUtils.isNotBlank(team.getWorksCode())) {
            if (flag > 0) {
                sql.append(",");
            }
            sql.append("worksCode='").append(team.getWorksCode()).append("'");
            flag++;
        }

        if (StringUtils.isNotBlank(team.getWorksName())) {
            if (flag > 0) {
                sql.append(",");
            }
            sql.append("worksName='").append(team.getWorksName()).append("'");
            flag++;
        }

        if (StringUtils.isNotBlank(team.getSubclass())) {
            if (flag > 0) {
                sql.append(",");
            }
            sql.append("subclass='").append(team.getSubclass()).append("'");
            flag++;
        }
        if (flag == 0) {
            return;
        }
        sql.append(" where id=?");

        this.pstmt = this.conn.prepareStatement(sql.toString());
        this.pstmt.setInt(1, team.getId());
        this.pstmt.execute();

    }

    @Override
    public List<Team> findAll() throws SQLException {
        String sql = "select " +
                "id," +
                "teamName," +
                "loginName," +
                "password," +
                "teacherId," +
                "teacherName," +
                "teacherId2," +
                "teacherName2," +
                "studentId," +
                "studentName," +
                "upload," +
                "audit," +
                "createTime," +
                "competitionId," +
                "checkTeacherId, " +
                "worksName," +
                "category," +
                "subclass," +
                "worksCode " +
                "from team";
        this.pstmt = conn.prepareStatement(sql);
        ResultSet rs = this.pstmt.executeQuery();
        List<Team> list = new ArrayList<>();
        while (rs.next()) {
            Team team = new Team();
            team.setId(rs.getInt(1));
            team.setTeamName(rs.getString(2));
            team.setLoginName(rs.getString(3));
            team.setPassword(rs.getString(4));
            team.setTeacherId(rs.getInt(5));
            team.setTeacherName(rs.getString(6));
            team.setTeacherId2(rs.getInt(7));
            team.setTeacherName2(rs.getString(8));
            team.setStudentId(rs.getInt(9));
            team.setStudentName(rs.getString(10));
            team.setUpload(rs.getString(11));
            team.setAudit(rs.getString(12));
            team.setCreateTime(rs.getDate(13));
            team.setCompetitionId(rs.getInt(14));
            team.setCheckTeacherId(rs.getInt(15));
            team.setWorksName(rs.getString(16));
            team.setCategory(rs.getString(17));
            team.setSubclass(rs.getString(18));
            team.setWorksCode(rs.getString(19));
            list.add(team);
        }
        this.pstmt.close();
        return list;
    }
}