package com.example.competition.entity;

import java.util.Date;

public class Notice {
    private Integer id;
    private String title;
    private String content;
    private String img;
    private Date createTime;

    public Notice() {
    }

    public Notice(String title, String content, String img) {
        this.title = title;
        this.content = content;
        this.img = img;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
