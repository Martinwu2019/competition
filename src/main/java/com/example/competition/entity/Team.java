package com.example.competition.entity;

import java.util.Date;

public class Team {
    private Integer id;
    private String teamName;
    private String loginName;
    private String password;
    private Integer teacherId;
    private String teacherName;
    private Integer teacherId2;
    private String teacherName2;
    private Integer studentId;
    private String studentName;
    private String upload;
    private String audit;
    private Date createTime;
    private Integer competitionId;
    private Integer checkTeacherId;
    private String worksName;
    private String category;
    private String subclass;
    private String worksCode;

    public Team() {
    }

    public Integer getCheckTeacherId() {
        return checkTeacherId;
    }

    public void setCheckTeacherId(Integer checkTeacherId) {
        this.checkTeacherId = checkTeacherId;
    }

    public Team(String teamName, String loginName, String password, String teacherName, String teacherName2, Integer studentId, String studentName, Integer competitionId) {
        this.teamName = teamName;
//        this.loginName = loginName;
//        this.password = password;
        this.teacherName = teacherName;
        this.teacherName2 = teacherName2;
        this.studentId = studentId;
        this.studentName = studentName;
        this.competitionId = competitionId;
        this.createTime = new Date();
        this.audit = "待审核";
    }

    public String getWorksName() {
        return worksName;
    }

    public void setWorksName(String worksName) {
        this.worksName = worksName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubclass() {
        return subclass;
    }

    public void setSubclass(String subclass) {
        this.subclass = subclass;
    }

    public String getWorksCode() {
        return worksCode;
    }

    public void setWorksCode(String worksCode) {
        this.worksCode = worksCode;
    }

    public Integer getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Integer competitionId) {
        this.competitionId = competitionId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getTeacherId2() {
        return teacherId2;
    }

    public void setTeacherId2(Integer teacherId2) {
        this.teacherId2 = teacherId2;
    }

    public String getTeacherName2() {
        return teacherName2;
    }

    public void setTeacherName2(String teacherName2) {
        this.teacherName2 = teacherName2;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getUpload() {
        return upload;
    }

    public void setUpload(String upload) {
        this.upload = upload;
    }

    public String getAudit() {
        return audit;
    }

    public void setAudit(String audit) {
        this.audit = audit;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
