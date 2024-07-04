package com.example.competition.dao;

import com.example.competition.entity.TeamMember;

import java.sql.SQLException;
import java.util.List;

public interface TeamMemberDao {

    TeamMember getByStuId(Integer stuId, Integer competitionId) throws SQLException;

    List<TeamMember> getByComIdAndTeamId(Integer competitionId, Integer teamId) throws SQLException;

    List<TeamMember> getByStuId(Integer stuId) throws SQLException;

    void save(TeamMember teamMember) throws SQLException;

    void deleteByStuIdAndTeam(Integer sId, Integer id) throws SQLException;
}