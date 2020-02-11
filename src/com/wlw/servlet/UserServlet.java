package com.wlw.servlet;

import com.wlw.dao.UserDao;
import com.wlw.domain.User;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by 孙弘炜 on 2016/1/25 0025.
 */

public class UserServlet extends HttpServlet {
    public UserServlet() {

    }

    public void destroy() {
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String type = request.getParameter("type");
        if ("addUser".equals(type)) {
            try {
                addUser(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                out.println("添加用户信息错误");
            }
        } else if ("queryAllUser".equals(type)) {
            try {
                queryAllUser(request, response);
            } catch (Exception e) {
                out.println("查询用户信息错误");
            }
        } else if ("recordUser".equals(type)) {
            try {
                recordUser(request, response);
            } catch (Exception e) {
                out.println("记录访问错误");
            }
        }
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //添加用户进入数据库
        UserDao dao = new UserDao();
        User user = new User();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        user.setUsername(username);
        user.setPassword(password);
        dao.adduser(user);

    }

    private void queryAllUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //从数据库查询所有用户

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();


        UserDao dao = new UserDao();
        List<User> users = dao.getalluser();

        request.setAttribute("users", users);
//        request.getRequestDispatcher("orderlogindex.jsp").forward(request, response);
//        response.sendRedirect("orderlogindex.jsp");
        out.println("<HTML>");
        out.println("<BODY>");
        for(int i=0;i<users.size();i++){
            out.print("User_id: "+users.get(i).getUser_id()+"   ");
            out.print("username: "+users.get(i).getUsername()+"   ");
            out.print("mobilephone: "+users.get(i).getMobilephone()+"  ");
            out.print("password: "+users.get(i).getPassword()+"   ");
            out.print("usercode: "+users.get(i).getUsercode()+"   ");
            out.print("state: "+users.get(i).getCheckstate()+"  ");
            out.print("<br>");
        }
            out.println("</BODY>");
            out.println("</HTML>");
    }

    private void recordUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //记录用户访问次数

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        if (session.isNew()) {
            session.setAttribute("count",1);
        } else if (session.getAttribute("count")!=null){
            int t=Integer.parseInt(String.valueOf(session.getAttribute("count")));
            t++;
            session.setAttribute("count",t);
        }else{
            out.println("error!");
        }
        out.println("<HTML>");
        out.println("<BODY>");
        out.println("当前访问的次数为 " + session.getAttribute("count") + "  次!");
        out.println("</BODY>");
        out.println("</HTML>");
    }

    public void init() throws ServletException {

    }

}