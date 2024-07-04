package com.example.competition.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

@WebServlet(name = "downloadServlet", value = "/downloadServlet")
public class DownloadServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String filePath = request.getParameter("filePath");
        String ext = filePath.replace("uploads/", "").replaceAll("/","");
        // 设置响应头，指示浏览器下载该文件
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename="+ext);

        // 获取文件的二进制内容
        byte[] fileContent = getFileContent(filePath);

        try (OutputStream outputStream = response.getOutputStream()) {
            // 将文件的二进制内容写入 ServletOutputStream 中
            outputStream.write(fileContent);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private byte[] getFileContent(String filePath) throws IOException {
        // 从文件中读取二进制内容
        String uploadPath = getServletContext().getRealPath("") + File.separator;
        File file = new File(uploadPath+filePath);
        byte[] fileContent = Files.readAllBytes(file.toPath());
        return fileContent;
    }
}
