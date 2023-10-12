package com.hhx.service;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/api")
public class APIServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp){
        String method = req.getMethod();
        String servletPath = req.getServletPath();
        System.out.println(servletPath);

        String contextPath = req.getContextPath();
        System.out.println(contextPath);
        //部署名+资源名
        System.out.println(req.getRequestURI());
        //全名
        System.out.println(req.getRequestURL());
    }
}
