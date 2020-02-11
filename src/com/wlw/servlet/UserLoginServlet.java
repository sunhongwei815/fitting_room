package com.wlw.servlet;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.HttpRetryException;

import com.alibaba.fastjson.JSONObject;
import com.wlw.*;
import com.wlw.domain.User;
import com.wlw.dao.UserDao;

/**
 * Created by 孙弘炜 on 2016/1/24 0024.
 */
public class UserLoginServlet extends HttpServlet {
 //用户登陆
    public  UserLoginServlet(){
        super();
    }

    public void destroy(){
        super.destroy();
    }

    public void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
           doPost(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();

        User user=new User();
        User input=new User();
        UserDao dao=new UserDao();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        user.setUsername(username);
        user.setPassword(password);

        HttpSession session=request.getSession();

        session.setAttribute("username",username);
        session.setMaxInactiveInterval(30*60);

        if(username!=null){                 //如果输入名字为不为空
            try {
                String json=" ";         //判断密码是否正确
                input=dao.getuserbyname(username);                 //如果输入名字存在
            if (input.getPassword().equals(user.getPassword())) {    //如果密码正确
                json="{success:true,msg:'密码正确'}";
                session.setAttribute("user_id",input.getUser_id());
                response.sendRedirect("index.jsp?user_id="+input.getUser_id());      //返回成功页
            }else {
                json="{success:false,msg:'密码不正确'}";
               // response.sendRedirect("jsp/userLogin.jsp");      //返回失败页面
            } out.write(json);
        } catch (Exception e) {
                response.sendRedirect("jsp/userLogin.jsp");       //显示“用户名不存在”
            }}

    }


    public void init() throws  ServletException{


    }

}