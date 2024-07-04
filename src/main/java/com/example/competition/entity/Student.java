package com.example.competition.entity;

import java.util.Date;

public class Student {
    private Integer id;
    private String userName;
    private String password;
    private String realName;
    private Integer age;
    private String phone;
    private String email;
    private String grade;
    private String major;
    private String identityCode;
    private Date createTime;

    public Student() {
    }

    public Student(String userName, String password, String realName, Integer age, String phone, String email, String grade, String major, String identityCode) {
        this.userName = userName;
        this.password = password;
        this.realName = realName;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.grade = grade;
        this.major = major;
        this.identityCode = identityCode;
        this.createTime = new Date();
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getIdentityCode() {
        return identityCode;
    }

    public void setIdentityCode(String identityCode) {
        this.identityCode = identityCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
