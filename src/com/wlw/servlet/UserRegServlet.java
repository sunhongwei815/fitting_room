package com.wlw.servlet;

import com.alibaba.fastjson.JSONObject;
import com.wlw.dao.UserDao;
import com.wlw.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


/**
 * Created by 孙弘炜 on 2016/1/24 0024.
 */
public class UserRegServlet extends HttpServlet {
//用户注册

   /* public UserRegServlet() {
        super();
    }*/

    /*public void destroy() {
        super.destroy();
    }*/


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        User user = new User();
        UserDao dao = new UserDao();
        String username;          //用户名
        String setpassword;      //设置密码
        String checkpassword;   //确认密码
        String mobilephone;   //手机号
        String code;  //验证码
        try {
            username = request.getParameter("username");
            setpassword = request.getParameter("setpassword");
            checkpassword = request.getParameter("checkpassword");
            mobilephone = request.getParameter("mobilephone");
            code=request.getParameter("code");     //用户输入的验证码
            HttpSession session=request.getSession();
            String checkcode=(String)session.getAttribute("checkcode");   //图片显示验证码

            String json1=" ";    //json1 判断用户名是否已存在
            String json2=" ";    //json2 判断验证码是否正确
            if(!isExisted(username)){
                    json1= "{success:true,msg:'用户名可用'}";                //用户名为新，可以注册该用户
               if (setpassword.equals(checkpassword)) {        //如果密码正确
                   user.setUsername(username);
                   user.setPassword(setpassword);
                   user.setMobilephone(mobilephone);
                   dao.adduser(user);
                   user = dao.getuserbyname(username);
                   session.setAttribute("user_id", user.getUser_id());    //存储用户信息，返回注册成功
                   response.sendRedirect("index.jsp?user_id=" + user.getUser_id());
                   session.removeAttribute("checkcode");
               }}else{
                     json1="{success:false,msg='用户名已存在'}";                 //如果用户名重复，输出“用户名已存在”
                 }
                     out.write(json1);
         if (code.equals(checkcode)) {
                json2="{success:true,msg:'验证码正确'}";
         } else {
                json2="{success:false,msg:'验证码错误'}";    //验证码不正确，发送失败信息
            }
                out.write(json2);
        }catch (Exception e){
                response.sendRedirect("jsp/userRegister.jsp");
            }

    }

   //根据用户名判断用户名是否已经存在

    public boolean isExisted(String username) throws Exception{
        boolean flag=false;
        UserDao dao=new UserDao();

        List<User> users=dao.getalluser();
        for(int i=0;i<users.size();i++){
            if(username.equals(users.get(i).getUsername())){
            flag=true;  //用户名存在，返回true
        }
        }
        return flag;
    }


    public void init() throws ServletException {

    }


}
