package com.example.competition.servlet.competition;

import com.example.competition.dao.*;
import com.example.competition.dao.impl.*;
import com.example.competition.entity.*;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@WebServlet(name = "competitionAddServlet", value = "/competitionAddServlet")
public class CompetitionAddServlet extends HttpServlet {

    private CompetitionDao competitionDao = new CompetitionDaoImpl();
    private TeamMemberDao teamMemberDao = new TeamMemberDaoImpl();
    private StudentDao studentDao = new StudentDaoImpl();
    private TeamDao teamDao = new TeamDaoImpl();
    private WorksDao worksDao = new WorksDaoImpl();

    public CompetitionAddServlet() throws Exception {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HashMap map = new HashMap(4);
        try {
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            String teamRegTimeFmstr = request.getParameter("teamRegTimeFm");
            String teamRegTimeTostr = request.getParameter("teamRegTimeTo");
            String worksTimeFmstr = request.getParameter("worksTimeFm");
            String worksTimeTostr = request.getParameter("worksTimeTo");
            String checkTimeFmstr = request.getParameter("checkTimeFm");
            String checkTimeTostr = request.getParameter("checkTimeTo");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date teamRegTimeFm = formatter.parse(teamRegTimeFmstr);
            Date teamRegTimeTo = formatter.parse(teamRegTimeTostr);
            Date worksTimeFm = formatter.parse(worksTimeFmstr);
            Date worksTimeTo = formatter.parse(worksTimeTostr);
            Date checkTimeFm = formatter.parse(checkTimeFmstr);
            Date checkTimeTo = formatter.parse(checkTimeTostr);
            Competition competition = new Competition(title,content,teamRegTimeFm, teamRegTimeTo,worksTimeFm,worksTimeTo,checkTimeFm,checkTimeTo);
            competitionDao.save(competition);
            map.put("data", "");
            map.put("code", "0");
            map.put("msg", "比赛创建成功");
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
