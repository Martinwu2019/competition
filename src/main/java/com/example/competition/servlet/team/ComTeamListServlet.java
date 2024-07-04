package com.example.competition.servlet.team;

import com.example.competition.dao.CompetitionDao;
import com.example.competition.dao.TeamDao;
import com.example.competition.dao.TeamMemberDao;
import com.example.competition.dao.impl.CompetitionDaoImpl;
import com.example.competition.dao.impl.TeamDaoImpl;
import com.example.competition.dao.impl.TeamMemberDaoImpl;
import com.example.competition.entity.Competition;
import com.example.competition.entity.Team;
import com.example.competition.entity.TeamMember;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "comTeamListServlet", value = "/comTeamListServlet")
public class ComTeamListServlet extends HttpServlet {
    private TeamDao teamDao = new TeamDaoImpl();
    private TeamMemberDao teamMemberDao = new TeamMemberDaoImpl();
    private CompetitionDao competitionDao = new CompetitionDaoImpl();

    public ComTeamListServlet() throws Exception {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HashMap map = new HashMap(4);
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            List<Team> teamList = teamDao.findAll();
            teamList = teamList.stream().filter(team -> team.getCompetitionId().equals(id)).collect(Collectors.toList());
            map.put("data",teamList);
            map.put("code","0");
        } catch (Exception throwables) {
            throwables.printStackTrace();
            map.put("data","");
            map.put("code","1");
            map.put("msg",throwables.getMessage());
        }
        Gson gson = new Gson();
        String json = gson.toJson(map);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
    }
}
