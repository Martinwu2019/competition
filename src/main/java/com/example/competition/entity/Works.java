package com.example.competition.entity;

import java.util.Date;
import java.util.UUID;

public class Works {
    private Integer id;
    private String worksName;
    private String category;
    private String subclass;
    private String worksCode;
    private String filePath;
    private String audit;
    private Date createTime;
    private Integer teamId;

    public Works(String worksName, String category, String subclass, String filePath, Integer teamId) {
        this.worksName = worksName;
        this.category = category;
        this.subclass = subclass;
        this.filePath = filePath;
        this.teamId = teamId;
        this.audit = "未审核";
        this.createTime = new Date();
        this.worksCode = UUID.randomUUID().toString().replaceAll("-","");
    }

    public Works() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
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

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }
}
