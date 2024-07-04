package com.example.competition.servlet;

import com.example.competition.dao.StudentDao;
import com.example.competition.dao.impl.StudentDaoImpl;
import com.example.competition.entity.Student;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registerServlet", value = "/registerServlet")
public class RegisterServlet extends HttpServlet {

    private StudentDao studentDao = new StudentDaoImpl();

    public RegisterServlet() throws Exception {
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        boolean flag = true;
        String error = "注册失败";
        try {
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

            studentDao.save(student);
        } catch (Exception e) {
            flag = false;
            error = e.getMessage();
            System.out.println(e.getMessage() + e);
        }

        if (flag) {
            request.setAttribute("tip", "注册成功");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            request.setAttribute("tip", error);
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }

}
