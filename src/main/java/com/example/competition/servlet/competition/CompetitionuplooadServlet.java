package com.example.competition.servlet.competition;

import com.example.competition.dao.*;
import com.example.competition.dao.impl.*;
import com.example.competition.entity.*;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

@WebServlet(name = "competitionuplooadServlet", value = "/competitionuplooadServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class CompetitionuplooadServlet extends HttpServlet {

    private CompetitionDao competitionDao = new CompetitionDaoImpl();
    private TeamMemberDao teamMemberDao = new TeamMemberDaoImpl();
    private StudentDao studentDao = new StudentDaoImpl();
    private TeamDao teamDao = new TeamDaoImpl();
    private WorksDao worksDao = new WorksDaoImpl();

    public CompetitionuplooadServlet() throws Exception {
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HashMap map = new HashMap(4);
        try {
            request.setCharacterEncoding("UTF-8");
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
                throw new RuntimeException("您不是团队负责人，无法提交作品");
            }
            Competition competition = competitionDao.findById(team.getCompetitionId());
            if (competition == null) {
                throw new RuntimeException("不存在比赛");
            }
            Date date = new Date();
            if (competition.getWorksTimeFm().after(date)) {
                throw new RuntimeException("未到作品提交时间");
            }
            if (competition.getTeamRegTimeTo().before(date)) {
                throw new RuntimeException("作品提交时间已结束");
            }
            String worksName = request.getParameter("worksName");
            String category = request.getParameter("category");
            String subclass = request.getParameter("subclass");

            String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String webapp = uploadPath.substring(0, uploadPath.lastIndexOf("target"));

            Part filePart = request.getPart("filePath");
            String fileName = filePart.getSubmittedFileName();
            String ext = fileName.substring(fileName.lastIndexOf("."));
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            fileName = uuid + ext;
            String filePath = uploadPath + File.separator + uuid+ext;
            filePart.write(filePath);
            File file = new File(filePath);
            File out = new File(webapp + "src/main/webapp/uploads/"+fileName);
            Files.copy(Paths.get(file.toURI()), Paths.get(out.toURI()));

//            Works works = new Works(worksName, category, subclass,"/uploads/"+fileName , teamMember.getTeamId());
//            worksDao.save(works);
            Team update = new Team();
            update.setId(team.getId());
            update.setWorksCode(UUID.randomUUID().toString().replaceAll("-",""));
            update.setCategory(category);
            update.setSubclass(subclass);
            update.setWorksName(worksName);
//            update.setUpload("已上传");
            update.setUpload("/uploads/"+fileName);
            teamDao.updateById(update);
            map.put("data", "");
            map.put("code", "0");
            map.put("msg", "上传成功");
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
