package com.example.competition.dao;

import com.example.competition.entity.Teacher;

import java.sql.SQLException;
import java.util.List;

public interface TeacherDao {

    Teacher getByUserName(String userName) throws SQLException;

    List<Teacher> findAll() throws SQLException;

    void save(Teacher teacher) throws SQLException;

    void deleteById(int id) throws SQLException;
}