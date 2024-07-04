package com.example.competition.servlet.team;

import com.example.competition.dao.CompetitionDao;
import com.example.competition.dao.TeamDao;
import com.example.competition.dao.TeamMemberDao;
import com.example.competition.dao.impl.CompetitionDaoImpl;
import com.example.competition.dao.impl.TeamDaoImpl;
import com.example.competition.dao.impl.TeamMemberDaoImpl;
import com.example.competition.entity.Student;
import com.example.competition.entity.Teacher;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "teamWithStuServlet", value = "/teamWithStuServlet")
public class TeamWithStuServlet extends HttpServlet {
    private TeamDao teamDao = new TeamDaoImpl();
    private TeamMemberDao teamMemberDao = new TeamMemberDaoImpl();
    private CompetitionDao competitionDao = new CompetitionDaoImpl();

    public TeamWithStuServlet() throws Exception {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HashMap map = new HashMap(4);
        try {
            Student owner = (Student) request.getSession().getAttribute("student");
            if (owner == null) {
                throw new RuntimeException("请先登录学生用户");
            }
            List<TeamMember> list = teamMemberDao.getByStuId(owner.getId());
            List<Team> stuList = new ArrayList<>();
            if (list != null && list.size() >0) {
                List<Integer> teamIdlist = list.stream().map(TeamMember::getTeamId).collect(Collectors.toList());
                stuList = teamDao.findAll();
                stuList = stuList.stream().filter(a -> teamIdlist.contains(a.getId())).collect(Collectors.toList());
            }
            map.put("data",stuList);
            map.put("code","0");
            map.put("count", stuList.size());
        } catch (SQLException throwables) {
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
