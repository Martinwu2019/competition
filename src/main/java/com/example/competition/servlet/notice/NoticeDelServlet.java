package com.example.competition.servlet.notice;

import com.example.competition.dao.NoticeDao;
import com.example.competition.dao.impl.NoticeDaoImpl;
import com.example.competition.entity.Notice;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "noticeDelServlet", value = "/noticeDelServlet")
public class NoticeDelServlet extends HttpServlet {

    private NoticeDao noticeDao = new NoticeDaoImpl();

    public NoticeDelServlet() throws Exception {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Map<String, String> map = new HashMap<>();
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            noticeDao.deleteById(id);
            map.put("data", "");
            map.put("code", "0");
            map.put("msg", "删除成功");
        }catch (Exception e) {
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
