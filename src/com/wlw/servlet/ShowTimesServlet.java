package com.wlw.servlet;
//ShowTimesServlet.java /*Servlet实现访问次数的例子!*/
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
/*
这个类实现访问次数。显示访问次数！看是第几次访问！
*/
public class ShowTimesServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, java.io.IOException {
        response.setContentType(" text/html;charset=utf-8");
        HttpSession session = request.getSession();
        if (session.isNew()) {
            session.setAttribute("count", 1);
            response.getWriter().print(" Welcom,You are first time to visit!");
        } else {
            int t = Integer.parseInt(String.valueOf(session.getAttribute("count")));
            t++;
            session.setAttribute("count", t);
            response.getWriter().print(" Welcome Backer");
        }
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<BODY>");
        out.println("当前访问的次数为 " + session.getAttribute("count") + "  次!");
        out.println("</BODY>");
        out.println("</HTML>");
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, java.io.IOException {
        doGet(request,response);
    }
}