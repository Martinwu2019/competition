package com.example.competition.servlet.competition;

import com.example.competition.dao.CompetitionDao;
import com.example.competition.dao.impl.CompetitionDaoImpl;
import com.example.competition.entity.Competition;
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

@WebServlet(name = "competitionServlet", value = "/competitionServlet")
public class CompetitionServlet extends HttpServlet {

    private CompetitionDao competitionDao = new CompetitionDaoImpl();

    public CompetitionServlet() throws Exception {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            List<Competition> list = competitionDao.findAll();
            Gson gson = new Gson();
            HashMap map = new HashMap();
            map.put("data", list);
            map.put("code", 0);
            map.put("count", list.size());
            map.put("msg", "");
            String json = gson.toJson(map);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(json);
            out.flush();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
