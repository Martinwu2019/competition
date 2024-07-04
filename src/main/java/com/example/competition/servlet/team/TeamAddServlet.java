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
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;

@WebServlet(name = "teamAddServlet", value = "/teamAddServlet")
public class TeamAddServlet extends HttpServlet {
    private TeamDao teamDao = new TeamDaoImpl();
    private TeamMemberDao teamMemberDao = new TeamMemberDaoImpl();
    private CompetitionDao competitionDao = new CompetitionDaoImpl();

    public TeamAddServlet() throws Exception {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HashMap map = new HashMap(4);
        try {
            String teamName = request.getParameter("teamName");
//            String loginName = request.getParameter("loginName");
//            String password = request.getParameter("password");
            String teacherName = request.getParameter("teacherName");
            String teacherName2 = request.getParameter("teacherName2");
            Integer studentId = Integer.parseInt(request.getParameter("studentId"));
            String  studentName = request.getParameter("studentName");
            Integer  competitionId = Integer.parseInt(request.getParameter("competitionId"));
            Competition competition = competitionDao.findById(competitionId);
            if (competition == null) {
                throw new RuntimeException("比赛不存在");
            }
            Date date = new Date();
            if (competition.getTeamRegTimeFm().after(date)) {
                throw new RuntimeException("未到团队注册时间");
            }
            if (competition.getTeamRegTimeTo().before(date)) {
                throw new RuntimeException("团队注册时间已结束");
            }
            TeamMember check = teamMemberDao.getByStuId(studentId, competitionId);
            if (check != null) {
                throw new RuntimeException("您已有团队");
            }
            Team team = new Team(teamName,null,null,teacherName,teacherName2,studentId,studentName,competitionId);
            team = teamDao.save(team);
            TeamMember teamMember = new TeamMember(team.getId(), studentId, competitionId);
            teamMemberDao.save(teamMember);

            map.put("data","");
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
