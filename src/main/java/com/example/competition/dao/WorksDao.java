package com.example.competition.dao;

import com.example.competition.entity.Works;

import java.sql.SQLException;

public interface WorksDao {

    void save(Works works) throws SQLException;
}