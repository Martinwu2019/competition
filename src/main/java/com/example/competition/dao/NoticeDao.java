package com.example.competition.dao;

import com.example.competition.entity.Notice;

import java.sql.SQLException;
import java.util.List;

public interface NoticeDao {

    List<Notice> findAll(String title) throws SQLException;

    List<Notice> findByPage(String title, int page, int pageSize) throws SQLException;

    void save(Notice notice) throws SQLException;

    void deleteById(Integer id) throws SQLException;
}