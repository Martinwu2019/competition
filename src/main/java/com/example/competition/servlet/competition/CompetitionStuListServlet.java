package com.example.competition.servlet.competition;

import com.example.competition.dao.CompetitionDao;
import com.example.competition.dao.StudentDao;
import com.example.competition.dao.TeamMemberDao;
import com.example.competition.dao.impl.CompetitionDaoImpl;
import com.example.competition.dao.impl.StudentDaoImpl;
import com.example.competition.dao.impl.TeamMemberDaoImpl;
import com.example.competition.entity.Student;
import com.example.competition.entity.TeamMember;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "competitionStuListServlet", value = "/competitionStuListServlet")
public class CompetitionStuListServlet extends HttpServlet {

    private CompetitionDao competitionDao = new CompetitionDaoImpl();
    private TeamMemberDao teamMemberDao = new TeamMemberDaoImpl();
    private StudentDao studentDao = new StudentDaoImpl();

    public CompetitionStuListServlet() throws Exception {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HashMap map = new HashMap(4);
        try {
            Integer comId = Integer.parseInt(request.getParameter("comId"));
            HttpSession session = request.getSession();
            Student owner = (Student) session.getAttribute("student");
            TeamMember teamMember = teamMemberDao.getByStuId(owner.getId(), comId);
            if (teamMember == null) {
                throw new RuntimeException("您没有团队");
            }
            List<TeamMember> teamMembers = teamMemberDao.getByComIdAndTeamId(comId, teamMember.getTeamId());
            List<Integer> stuIds = teamMembers.stream().map(TeamMember::getStudentId).collect(Collectors.toList());
            List<Student> studentList = studentDao.listByIds(stuIds);
            map.put("data", studentList);
            map.put("code", "0");

        } catch (Exception throwables) {
            throwables.printStackTrace();
            map.put("data", "");
            map.put("code", "1");
            map.put("msg", throwables.getMessage());
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