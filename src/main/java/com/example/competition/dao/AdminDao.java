package com.example.competition.dao;

import com.example.competition.entity.Admin;

import java.sql.SQLException;

public interface AdminDao {

    Admin getByUserName(String userName) throws SQLException;
}