package com.servlet.test.controller;


import com.servlet.test.db.entity.customer.Customer;
import com.servlet.test.db.entity.customer.CustomerTitle;
import com.servlet.test.db.entity.customer.dao.CustomerDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.StringJoiner;

@WebServlet(value = "/register/test")
public class HttpFront extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Servlet init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {






//        resp.setContentType("text/html; charset=utf-8");
//        resp.getWriter().write("<h1>Hello ${name}!</h1>".replace("${name}", parseName(req)));
//        resp.getWriter().write("<br>");
//        resp.getWriter().write(getAllParameters(req));
//        resp.getWriter().write("<br>");
//        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        resp.getWriter().write(currentTime);
//        resp.getWriter().write("<br>");
//        resp.getWriter().write(getAllHeaders(req));
//        resp.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private String parseName(HttpServletRequest request){
        if(request.getParameterMap().containsKey("name")){
            return request.getParameter("name");
        }
        return "unnamed";
    }

    private String getAllParameters(HttpServletRequest request) {
        StringJoiner result = new StringJoiner("<br>");

        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            String parameterValues = Arrays.toString(request.getParameterValues(parameterName));
            result.add(parameterName + " = " + parameterValues);
        }
        return result.toString();
    }

    private String getAllHeaders(HttpServletRequest request){
        StringJoiner result = new StringJoiner("<br>");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            result.add(headerName + " = " + headerValue);
        }
        return result.toString();
    }
}
