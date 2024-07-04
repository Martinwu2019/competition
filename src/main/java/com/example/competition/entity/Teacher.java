package com.example.competition.entity;

import java.util.Date;

public class Teacher {
    private Integer id;
    private String userName;
    private String password;
    private String realName;
    private String phone;
    private String email;
    private Date createTime;

    public Teacher(String userName, String password, String realName, String phone, String email) {
        this.userName = userName;
        this.password = password;
        this.realName = realName;
        this.phone = phone;
        this.email = email;
        this.createTime = new Date();
    }

    public Teacher() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
