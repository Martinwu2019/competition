package com.example.competition.servlet.student;

import com.example.competition.dao.StudentDao;
import com.example.competition.dao.TeamDao;
import com.example.competition.dao.TeamMemberDao;
import com.example.competition.dao.impl.StudentDaoImpl;
import com.example.competition.dao.impl.TeamDaoImpl;
import com.example.competition.dao.impl.TeamMemberDaoImpl;
import com.example.competition.entity.Student;
import com.example.competition.entity.Team;
import com.example.competition.entity.TeamMember;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet(name = "studentOutServlet", value = "/studentOutServlet")
public class StudentOutServlet extends HttpServlet {
    private StudentDao studentDao = new StudentDaoImpl();
    private TeamDao teamDao = new TeamDaoImpl();
    private TeamMemberDao teamMemberDao = new TeamMemberDaoImpl();

    public StudentOutServlet() throws Exception {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.getSession().removeAttribute("student");
        request.getSession().removeAttribute("stuId");
        response.sendRedirect("login.jsp");

    }
}
