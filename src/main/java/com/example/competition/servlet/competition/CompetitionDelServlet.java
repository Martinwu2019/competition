package com.example.competition.servlet.competition;

import com.example.competition.dao.*;
import com.example.competition.dao.impl.*;
import com.example.competition.entity.Competition;
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

@WebServlet(name = "competitionDelServlet", value = "/competitionDelServlet")
public class CompetitionDelServlet extends HttpServlet {

    private CompetitionDao competitionDao = new CompetitionDaoImpl();
    private TeamMemberDao teamMemberDao = new TeamMemberDaoImpl();
    private StudentDao studentDao = new StudentDaoImpl();
    private TeamDao teamDao = new TeamDaoImpl();
    private WorksDao worksDao = new WorksDaoImpl();

    public CompetitionDelServlet() throws Exception {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HashMap map = new HashMap(4);
        try {
            String id = request.getParameter("id");

            competitionDao.deleteById(Integer.parseInt(id));
            map.put("data", "");
            map.put("code", "0");
            map.put("msg", "比赛删除成功");
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
