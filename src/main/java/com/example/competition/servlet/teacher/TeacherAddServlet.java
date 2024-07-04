package com.example.competition.servlet.teacher;

import com.example.competition.dao.*;
import com.example.competition.dao.impl.*;
import com.example.competition.entity.Competition;
import com.example.competition.entity.Teacher;
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

@WebServlet(name = "teacherAddServlet", value = "/teacherAddServlet")
public class TeacherAddServlet extends HttpServlet {

    private TeacherDao teacherDao = new TeacherDaoImpl();

    public TeacherAddServlet() throws Exception {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HashMap map = new HashMap(4);
        try {
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            String realName = request.getParameter("realName");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");

            Teacher check = teacherDao.getByUserName(userName);
            if (check != null) {
                throw new RuntimeException("教师信息已存在");
            }
            Teacher teacher = new Teacher(userName, password, realName, phone, email);
            teacherDao.save(teacher);
            map.put("data", "");
            map.put("code", "0");
            map.put("msg", "新增老师成功");
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
