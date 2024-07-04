package com.example.competition.dao;

import com.example.competition.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {

    Student save(Student student) throws Exception;

    Student findByIdentityCode(String identityCode) throws SQLException;
    Student findByUserName(String userName) throws SQLException;

    List<Student> listByIds(List<Integer> stuIds) throws SQLException;
}