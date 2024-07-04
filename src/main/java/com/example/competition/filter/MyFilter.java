package com.example.competition.filter;

import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

public class MyFilter implements Filter {

    private String[] excludedPaths; // 需要排除的路径
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 初始化操作，可以获取配置参数等
        excludedPaths = new String[]{"/loginServlet", "/registerServlet",
                "/adminLoginServlet","/studentOutServlet",
                "/noticeServlet"};
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 在请求处理之前进行预处理
        System.out.println("LoggingFilter: Request received for " + request.getRequestURI());
// 获取当前请求的路径
        String requestPath = request.getRequestURI();

        // 检查请求路径是否在排除的路径列表中
        boolean isExcluded = false;
        if (requestPath.contains(".jsp")) {
            isExcluded = true;
        } else {

            for (String excludedPath : excludedPaths) {
                if (requestPath.equals(excludedPath)) {
                    isExcluded = true;
                    break;
                }
            }
        }
        if (!isExcluded) {
            // 继续执行过滤器链，或者调用目标资源
            HttpSession session = request.getSession();
            if (session.getAttribute("student") == null
                    && (session.getAttribute("admin") == null
                    && session.getAttribute("teacher") == null)) {
                throw new RemoteException("请先登录");
            }
        }

        try {
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            Map<String, String> map = new HashMap<>();
            Gson gson = new Gson();
            map.put("data", "");
            map.put("count", "0");
            map.put("code", "1");
            map.put("msg", e.getMessage());
            String json = gson.toJson(map);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(json);
            out.flush();
        }
    }

    @Override
    public void destroy() {
        // 销毁操作，如释放资源等
    }
}
