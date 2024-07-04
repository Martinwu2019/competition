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
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "teamInfoServlet", value = "/teamInfoServlet")
public class TeamInfoServlet extends HttpServlet {
    private TeamDao teamDao = new TeamDaoImpl();
    private TeamMemberDao teamMemberDao = new TeamMemberDaoImpl();

    public TeamInfoServlet() throws Exception {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            HashMap map = new HashMap(4);
            Integer stuId = Integer.parseInt(request.getParameter("stuId"));
            Integer competitionId = Integer.parseInt(request.getParameter("competitionId"));
            TeamMember teamMember = teamMemberDao.getByStuId(stuId,competitionId);
            if (teamMember == null)  {
                map.put("data", "");
                map.put("count", 0);
                map.put("code", 1);
                map.put("msg", "不存在团队，可以尝试创建");
            } else {
                Team team = teamDao.getById(teamMember.getTeamId());
                map.put("data", team);
                map.put("count", 1);
                map.put("code", 0);
                map.put("msg", "成功");
            }
            Gson gson = new Gson();

            String json = gson.toJson(map);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(json);
            out.flush();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }
}
