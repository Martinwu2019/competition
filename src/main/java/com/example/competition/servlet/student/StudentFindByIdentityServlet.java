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
import java.sql.SQLException;
import java.util.HashMap;

@WebServlet(name = "studentFindByIdentityServlet", value = "/studentFindByIdentityServlet")
public class StudentFindByIdentityServlet extends HttpServlet {
    private StudentDao studentDao = new StudentDaoImpl();
    private TeamDao teamDao = new TeamDaoImpl();
    private TeamMemberDao teamMemberDao = new TeamMemberDaoImpl();

    public StudentFindByIdentityServlet() throws Exception {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HashMap map = new HashMap(4);
        try {
            String identityCode = request.getParameter("identityCode");
            Integer comId = Integer.parseInt(request.getParameter("comId"));
            if (StringUtils.isBlank(identityCode)) {
                throw new RuntimeException("身份证不能为空");
            }

            HttpSession session = request.getSession();
            Student owner = (Student) session.getAttribute("student");
            if (owner == null) {
                throw new RuntimeException("请先登录");
            }

            Student student = studentDao.findByIdentityCode(identityCode);
            if (student == null) {
                throw new RuntimeException("学生信息不存在");
            }
            TeamMember teamMember = teamMemberDao.getByStuId(student.getId(), comId);
            if (teamMember != null) {
                throw new RuntimeException("该队员已有团队");
            }
            TeamMember ownerTeam = teamMemberDao.getByStuId(owner.getId(), comId);
            if (ownerTeam == null) {
                throw new RuntimeException("您不存在团队");
            }
            Team team = teamDao.getById(ownerTeam.getTeamId());
            if (team == null) {
                throw new RuntimeException("团队不存在");
            }
            if (!team.getStudentId().equals(owner.getId())) {
                throw new RuntimeException("您不是团队负责人，不能添加");
            }
            TeamMember add = new TeamMember();
            add.setStudentId(student.getId());
            add.setCompetitionId(comId);
            add.setTeamId(ownerTeam.getTeamId());
            teamMemberDao.save(add);
            map.put("data","");
            map.put("code","0");
        } catch (Exception throwables) {
            throwables.printStackTrace();
            map.put("data","");
            map.put("code","1");
            map.put("msg",throwables.getMessage());
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
