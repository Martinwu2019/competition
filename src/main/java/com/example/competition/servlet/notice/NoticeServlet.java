package com.example.competition.servlet.notice;

import com.example.competition.dao.NoticeDao;
import com.example.competition.dao.StudentDao;
import com.example.competition.dao.impl.NoticeDaoImpl;
import com.example.competition.dao.impl.StudentDaoImpl;
import com.example.competition.entity.Notice;
import com.example.competition.entity.Student;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "noticeServlet", value = "/noticeServlet")
public class NoticeServlet extends HttpServlet {

    private NoticeDao noticeDao = new NoticeDaoImpl();

    public NoticeServlet() throws Exception {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String title = request.getParameter("title");
        String pageStr = request.getParameter("page");
        Integer page = 1;
        if (pageStr != null && !"".equals(pageStr)) {
            page = Integer.parseInt(pageStr);
        }
        Integer pageSize = 10;

        boolean flag = true;
        String error = "注册失败";
        try {
            List<Notice> list = noticeDao.findAll(title);
            int totalRecords = list.size(); // 总记录数
            int totalPages = (int) Math.ceil((double) totalRecords / pageSize);
            int startIndex = (page - 1) * pageSize; // 起始记录索引
            int endIndex = Math.min(startIndex + pageSize, totalRecords); // 结束记录索引
            List<Notice> pageList = list.subList(startIndex, endIndex); // 当前页的记录列表
            Gson gson = new Gson();
            HashMap map = new HashMap();
            map.put("data", list);
            map.put("code", 0);
            map.put("count", list.size());
            map.put("msg", "");
            String json = gson.toJson(map);

            request.setAttribute("noticeList", pageList);
            request.setAttribute("currentPage", page);
            request.setAttribute("totalPages", totalPages);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(json);
            out.flush();
            // 重定向请求到 JSP 页面
//            response.sendRedirect("homePage.jsp?page=" + page);
        } catch (Exception e) {
            flag = false;
            error = e.getMessage();
            System.out.println(e.getMessage() + e);
            request.setAttribute("noticeList", new ArrayList<>());
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }

}
