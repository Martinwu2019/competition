package com.example.competition.servlet.competition;

import com.example.competition.dao.CompetitionDao;
import com.example.competition.dao.StudentDao;
import com.example.competition.dao.TeamDao;
import com.example.competition.dao.TeamMemberDao;
import com.example.competition.dao.impl.CompetitionDaoImpl;
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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet(name = "competitionTeamAddStuServlet", value = "/competitionTeamAddStuServlet")
public class CompetitionTeamAddStuServlet extends HttpServlet {

    private CompetitionDao competitionDao = new CompetitionDaoImpl();
    private TeamMemberDao teamMemberDao = new TeamMemberDaoImpl();
    private TeamDao teamDao = new TeamDaoImpl();
    private StudentDao studentDao = new StudentDaoImpl();

    public CompetitionTeamAddStuServlet() throws Exception {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HashMap map = new HashMap(4);
        try {
            Integer comId = Integer.parseInt(request.getParameter("comId"));
            Student owner = (Student) request.getSession().getAttribute("student");
            TeamMember teamMember = teamMemberDao.getByStuId(owner.getId(), comId);
            if (teamMember == null) {
                throw new RuntimeException("您不存在团队");
            }
            Team team = teamDao.getById(teamMember.getTeamId());
            if (team == null) {
                throw new RuntimeException("团队不存在");
            }
            if (!team.getStudentId().equals(owner.getId())) {
                throw new RuntimeException("您不是团队负责人，无法新增队员");
            }
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            String realName = request.getParameter("realName");
            String ageStr = request.getParameter("age");
            Integer age = null;
            if (StringUtils.isBlank(ageStr)) {
                age = 0;
            } else {
                age = Integer.valueOf(ageStr);
            }
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String grade = request.getParameter("grade");
            String major = request.getParameter("major");
            String identityCode = request.getParameter("identityCode");
            if (StringUtils.isBlank(identityCode)) {
                throw new RuntimeException("身份证不能为空");
            }

            if (StringUtils.isBlank(userName)) {
                throw new RuntimeException("用户名不为空");
            }
            Student check = studentDao.findByUserName(userName);
            if (check != null) {
                throw new RuntimeException("用户名已存在");
            }
            check = studentDao.findByIdentityCode(identityCode);
            if (check != null) {
                throw new RuntimeException("身份证信息已存在");
            }



            Student student = new Student(userName, password, realName, age, phone, email, grade, major, identityCode);

            student = studentDao.save(student);
            TeamMember add = new TeamMember();
            add.setTeamId(teamMember.getTeamId());
            add.setCompetitionId(comId);
            add.setStudentId(student.getId());
            teamMemberDao.save(add);
            map.put("data", "");
            map.put("code", "0");
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
