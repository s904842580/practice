package com.hhx.service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@WebServlet(name = "ReqServlet", value = "/ReqServlet")
public class ReqServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        doPost(request,response);
        //获取表单中的单个数据
        String username = request.getParameter("uname");
        String password = request.getParameter("pwd");
        System.out.println(username);
        System.out.println(password);
        System.out.println("==========================");
        Map<String,String[]> parameterMap = request.getParameterMap();
        Set<Map.Entry<String,String[]>> entries = parameterMap.entrySet();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost....");
    }
}
