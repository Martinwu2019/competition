package com.example.competition.dao;

import com.example.competition.entity.Team;

import java.sql.SQLException;
import java.util.List;

public interface TeamDao {

    Team getById(Integer teamId) throws SQLException;

    Team save(Team team) throws SQLException;

    void deleteByTeamId(Integer id) throws SQLException;

    void updateById(Team team) throws SQLException;

    List<Team> findAll() throws SQLException;
}