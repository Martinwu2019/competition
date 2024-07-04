package com.example.competition.servlet;

import com.example.competition.dao.StudentDao;
import com.example.competition.dao.impl.StudentDaoImpl;
import com.example.competition.entity.Student;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet {

    private StudentDao studentDao = new StudentDaoImpl();

    public LoginServlet() throws Exception {
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        boolean flag = true;
        String error = "注册失败";
        Student student = null;
        try {
            student = studentDao.findByUserName(userName);
            if (student == null) {
                throw new RuntimeException("找不到账号注册信息");
            }
            if (!student.getPassword().equals(password)) {
                throw new RuntimeException("密码错误");
            }
        } catch (Exception e) {
            flag = false;
            error = e.getMessage();
            System.out.println(e.getMessage() + e);
        }

        if (flag) {
            request.setAttribute("tip", "登录成功");
            request.setAttribute("student", student);
            request.setAttribute("stuId", student.getId());
            // 获取当前会话，如果没有会话，则创建一个新的会话
            HttpSession session = request.getSession();
            // 在会话中设置一个名为 "username" 的属性
            session.setAttribute("student", student);
            session.setAttribute("stuId", student.getId());
            request.getRequestDispatcher("homepage.jsp").forward(request, response);
        } else {
            request.setAttribute("tip", error);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

}
