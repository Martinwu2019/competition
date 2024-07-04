package com.example.competition.dao;

import com.example.competition.entity.Competition;

import java.sql.SQLException;
import java.util.List;

public interface CompetitionDao {

    List<Competition> findAll() throws SQLException;

    Competition findById(Integer competitionId) throws SQLException;

    void save(Competition competition) throws SQLException;

    void deleteById(int parseInt) throws SQLException;
}