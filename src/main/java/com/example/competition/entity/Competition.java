package com.example.competition.entity;

import java.util.Date;

public class Competition {
    private Integer id;
    private String title;
    private String content;
    private Date teamRegTimeFm;
    private Date teamRegTimeTo;
    private Date worksTimeFm;
    private Date worksTimeTo;
    private Date checkTimeFm;
    private Date checkTimeTo;
    private Date createTime;

    public Competition() {
    }

    public Competition(String title, String content, Date teamRegTimeFm, Date teamRegTimeTo, Date worksTimeFm, Date worksTimeTo, Date checkTimeFm, Date checkTimeTo) {
        this.title = title;
        this.content = content;
        this.teamRegTimeFm = teamRegTimeFm;
        this.teamRegTimeTo = teamRegTimeTo;
        this.worksTimeFm = worksTimeFm;
        this.worksTimeTo = worksTimeTo;
        this.checkTimeFm = checkTimeFm;
        this.checkTimeTo = checkTimeTo;
        this.createTime = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTeamRegTimeFm() {
        return teamRegTimeFm;
    }

    public void setTeamRegTimeFm(Date teamRegTimeFm) {
        this.teamRegTimeFm = teamRegTimeFm;
    }

    public Date getTeamRegTimeTo() {
        return teamRegTimeTo;
    }

    public void setTeamRegTimeTo(Date teamRegTimeTo) {
        this.teamRegTimeTo = teamRegTimeTo;
    }

    public Date getWorksTimeFm() {
        return worksTimeFm;
    }

    public void setWorksTimeFm(Date worksTimeFm) {
        this.worksTimeFm = worksTimeFm;
    }

    public Date getWorksTimeTo() {
        return worksTimeTo;
    }

    public void setWorksTimeTo(Date worksTimeTo) {
        this.worksTimeTo = worksTimeTo;
    }

    public Date getCheckTimeFm() {
        return checkTimeFm;
    }

    public void setCheckTimeFm(Date checkTimeFm) {
        this.checkTimeFm = checkTimeFm;
    }

    public Date getCheckTimeTo() {
        return checkTimeTo;
    }

    public void setCheckTimeTo(Date checkTimeTo) {
        this.checkTimeTo = checkTimeTo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
