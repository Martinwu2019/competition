package com.example.competition.servlet.teacher;

import com.example.competition.dao.CompetitionDao;
import com.example.competition.dao.TeacherDao;
import com.example.competition.dao.TeamDao;
import com.example.competition.dao.impl.CompetitionDaoImpl;
import com.example.competition.dao.impl.TeacherDaoImpl;
import com.example.competition.dao.impl.TeamDaoImpl;
import com.example.competition.entity.Competition;
import com.example.competition.entity.Teacher;
import com.example.competition.entity.Team;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet(name = "teacherSendServlet", value = "/teacherSendServlet")
public class TeacherSendServlet extends HttpServlet {

    private TeacherDao teacherDao = new TeacherDaoImpl();
    private TeamDao teamDao = new TeamDaoImpl();
    private CompetitionDao competitionDao = new CompetitionDaoImpl();
//    private TeacherDao teacherDao = new TeacherDaoImpl();

    public TeacherSendServlet() throws Exception {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HashMap map = new HashMap(4);
        try {
            List<Team> teamList = teamDao.findAll();
            List<Competition> competitions = competitionDao.findAll();
            competitions = competitions.stream().filter(a -> a.getCheckTimeFm().before(new Date()))
                    .filter(a -> a.getCheckTimeTo().after(new Date()))
                    .collect(Collectors.toList());
            List<Integer> comIds = competitions.stream().map(Competition::getId).collect(Collectors.toList());
            teamList = teamList.stream().filter(a -> a.getCheckTeacherId() == null || a.getCheckTeacherId() <=0)
                    .filter(a -> comIds.contains(a.getCompetitionId()))
                    .collect(Collectors.toList());
            if (teamList.size() != 0) {
                List<Teacher> teachers = teacherDao.findAll();
                int tSize = teachers.size();
                if (tSize == 0) {
                    throw new RuntimeException("可用教师数量不足");
                }
                int loop = 0;
                for (Team team : teamList) {
                    if (loop>=teachers.size()) {
                        loop = 0;
                    }
                    Team update = new Team();
                    update.setId(team.getId());
                    update.setCheckTeacherId(teachers.get(loop).getId());
                    teamDao.updateById(update);
                }
            } else {
                throw new RuntimeException("暂无可分配审核比赛团队");
            }
            map.put("data", "");
            map.put("code", "0");
            map.put("msg", "分配审核成功");
        } catch (Exception e) {
            map.put("data", "");
            map.put("code", "1");
            map.put("msg", e.getMessage());
            System.out.println(e.getMessage() + e);
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
