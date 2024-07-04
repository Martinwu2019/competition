package com.example.competition.servlet.admin.login;

import com.example.competition.dao.AdminDao;
import com.example.competition.dao.StudentDao;
import com.example.competition.dao.TeacherDao;
import com.example.competition.dao.TeamDao;
import com.example.competition.dao.impl.AdminDaoImpl;
import com.example.competition.dao.impl.StudentDaoImpl;
import com.example.competition.dao.impl.TeacherDaoImpl;
import com.example.competition.dao.impl.TeamDaoImpl;
import com.example.competition.dto.LoginUser;
import com.example.competition.entity.Admin;
import com.example.competition.entity.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;


@WebServlet(name = "adminLoginServlet", value = "/adminLoginServlet")
public class AdminLoginServlet extends HttpServlet {

    private TeacherDao teacherDao = new TeacherDaoImpl();
    private AdminDao adminDao = new AdminDaoImpl();

    public AdminLoginServlet() throws Exception {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String userName = request.getParameter("userAccount");
        String password = request.getParameter("userPassword");
        String radio = request.getParameter("radio");
        System.out.println(userName);
        Map<String, String> map = new HashMap<>();
        try {
            switch (radio) {
                case "teacher":
                    Teacher user = new Teacher();
                    user.setUserName(userName);
                    user.setPassword(password);
                    Teacher result = teacherDao.getByUserName(userName);
                    if (result == null) {
                        throw new RuntimeException("账号不存在");
                    }
                    if (!result.getPassword().equals(password)) {
                        throw new RuntimeException("密码错误");
                    }
                    request.setAttribute("username", userName);
                    // 获取当前会话，如果没有会话，则创建一个新的会话
                    HttpSession session = request.getSession();
                    // 在会话中设置一个名为 "username" 的属性
                    session.removeAttribute("admin");
                    session.setAttribute("teacher", result);
                    request.getRequestDispatcher("teacherindex.jsp").forward(request, response);
                    break;
                case "admin":
                    Admin admins = new Admin();
                    Admin result2 = adminDao.getByUserName(userName);
                    if (result2 == null) {
                        throw new RuntimeException("账号不一致");
                    }
                    if (!result2.getPassword().equals(password)) {
                        throw new RuntimeException("密码不一致");
                    }
                    request.setAttribute("username", userName);
                    // 获取当前会话，如果没有会话，则创建一个新的会话
                    HttpSession session2 = request.getSession();
                    // 在会话中设置一个名为 "username" 的属性
                    session2.removeAttribute("teacher");
                    session2.setAttribute("admin", result2);
                    request.getRequestDispatcher("adminindex.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            request.setAttribute("tip", e.getMessage());
            request.getRequestDispatcher("/adminlogin.jsp").forward(request, response);
        }
    }


}
