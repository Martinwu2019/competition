package com.example.competition.entity;

public class TeamMember {
    private Integer id;
    private Integer teamId;
    private Integer studentId;
    private Integer competitionId;

    public TeamMember() {
    }

    public TeamMember(Integer id, Integer studentId, Integer competitionId) {
        this.teamId = id;
        this.studentId = studentId;
        this.competitionId = competitionId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Integer competitionId) {
        this.competitionId = competitionId;
    }
}
