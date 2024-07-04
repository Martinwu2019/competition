package com.example.competition.servlet.notice;

import com.example.competition.dao.NoticeDao;
import com.example.competition.dao.impl.NoticeDaoImpl;
import com.example.competition.entity.Notice;
import com.google.gson.Gson;
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
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@WebServlet(name = "noticeAddServlet", value = "/noticeAddServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class NoticeAddServlet extends HttpServlet {

    private NoticeDao noticeDao = new NoticeDaoImpl();

    public NoticeAddServlet() throws Exception {
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Map<String, String> map = new HashMap<>();
        try {
            request.setCharacterEncoding("UTF-8");
            String title = request.getParameter("title");
            String content = request.getParameter("content");
//            String img = request.getParameter("img");
            String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String webapp = uploadPath.substring(0, uploadPath.lastIndexOf("target"));

            Part filePart = request.getPart("img");
            String fileName = filePart.getSubmittedFileName();
            String ext = fileName.substring(fileName.lastIndexOf("."));
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            fileName = uuid + ext;
            String filePath = uploadPath + File.separator + uuid+ext;
            filePart.write(filePath);
            File file = new File(filePath);
            File out = new File(webapp + "src/main/webapp/uploads/"+fileName);
            Files.copy(Paths.get(file.toURI()), Paths.get(out.toURI()));
            Notice notice = new Notice(title, content, "/uploads/" + fileName);
            noticeDao.save(notice);
            map.put("data", "");
            map.put("code", "0");
            map.put("msg", "上传成功");
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
