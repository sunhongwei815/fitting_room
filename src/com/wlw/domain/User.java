package com.wlw.domain;

/**
 * Created by 孙弘炜 on 2016/1/24 0024.
 */
public class User {

    private int user_id;    //用户id
    private int usercode;   //用户积分
    private String password;  //用户密码
    private String username;   //用户名
    private String mobilephone;    //用户电话
    private int checkstate;   //用户审核状态（0表示未通过，1表示已通过）

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id)
    {
        this.user_id = user_id;
    }

    public int getUsercode() {
        return usercode;
    }

    public void setUsercode(int usercode) {
        this.usercode = usercode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public int  getCheckstate() {
        return checkstate;
    }

    public void setCheckstate(int checkstate) {

        this.checkstate = checkstate;
    }


    public User(){

    }

}
