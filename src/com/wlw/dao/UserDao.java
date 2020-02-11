package com.wlw.dao;
import com.wlw.domain.User;


import java.sql.ResultSet;
import java.util.*;
import java.sql.*;


/**
 * Created by 孙弘炜 on 2016/1/24 0024.
 */


public class UserDao extends BaseDao{
    //向用户表内添加用户
    public void adduser(User user) throws Exception {
        Connection con = getCurrentConnection();
        String sql = "insert into user(user_id,username,mobilephone,usercode,password,checkstate) values(?,?,?,?,?,?)";
        PreparedStatement pres = con.prepareStatement(sql);
        pres.setInt(1, user.getUser_id());
        pres.setString(2, user.getUsername());
        pres.setString(3, user.getMobilephone());
        pres.setInt(4, user.getUsercode());
        pres.setString(5, user.getPassword());
        pres.setInt(6, user.getCheckstate());
        pres.executeUpdate();
        closePreparedStatement(pres);
        closeConnection(con);
    }

    //获取所有用户信息
    public List<User> getalluser() throws Exception {
        List<User> users = new ArrayList<User>();
        Connection con = getCurrentConnection();
        String sql = "Select * FROM user";
        PreparedStatement pres = con.prepareStatement(sql);
        ResultSet rs = pres.executeQuery();

        while (rs.next()) {
            int user_id = rs.getInt(1);
            String username = rs.getString(2);
            String mobilephone = rs.getString(3);
            int usercode = rs.getInt(4);
            String password = rs.getString(5);
            int checkstate = rs.getInt(6);
            User user = new User();
            user.setUser_id(user_id);
            user.setUsername(username);
            user.setPassword(password);
            user.setUsercode(usercode);
            user.setMobilephone(mobilephone);
            user.setCheckstate(checkstate);
            users.add(user);
        }
        closeAll(con, pres, rs);
        return users;
    }

    //根据用户ID获取某个用户信息
    public User getuserbyid(int user_id) throws Exception {
        Connection con = getCurrentConnection();
        String sql = "Select * From user where user_id=? ";
        PreparedStatement pres = con.prepareStatement(sql);
        pres.setInt(1, user_id);
        ResultSet rs = pres.executeQuery();
        User user = new User();
        while (rs.next()) {
            String username = rs.getString(2);
            String mobilephone = rs.getString(3);
            int usercode = rs.getInt(4);
            String password = rs.getString(5);
            int checkstate = rs.getInt(6);
            user.setUsercode(usercode);
            user.setPassword(password);
            user.setUsername(username);
            user.setMobilephone(mobilephone);
            user.setCheckstate(checkstate);
        }
        closeAll(con, pres, rs);
        return user;
    }


    //根据用户Name获取某个用户信息
    public User getuserbyname(String username) throws Exception {
        Connection con = getCurrentConnection();
        String sql = "Select * From user where username=? ";
        PreparedStatement pres = con.prepareStatement(sql);
        pres.setString(1, username);
        ResultSet rs = pres.executeQuery();
        User user = new User();
        while (rs.next()) {
            int user_id = rs.getInt(1);
            String mobilephone = rs.getString(3);
            int usercode = rs.getInt(4);
            String password = rs.getString(5);
            int checkstate = rs.getInt(6);
            user.setUsercode(usercode);
            user.setPassword(password);
            user.setUser_id(user_id);
            user.setMobilephone(mobilephone);
            user.setCheckstate(checkstate);
        }
        closeAll(con,pres,rs);
        return user;
    }

    //删除某个用户信息
    public void deleteUser(int user_id) throws Exception {
        Connection con = getCurrentConnection();
        String sql = "Delete From user where user_id=?";
        PreparedStatement pres = con.prepareStatement(sql);
        pres.setInt(1, user_id);
        pres.executeUpdate();
        closePreparedStatement(pres);
        closeConnection(con);
    }



}