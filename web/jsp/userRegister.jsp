<%--
  Created by IntelliJ IDEA.
  User: 牟国宏
  Date: 2016/1/29 0029
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>register</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet"href="../css/userRegister.css">
</head>
<body>
<div class="userRegister">
    <div class="panel panel-default">
        <div class="panel-heading">已有账号，点击<a href="userLogin.jsp">这里</a></div>
        <div class="panel-body">
            <form class="form-horizontal" action="/WLSYS/UserReg" method="post">
                <div class="form-group">
                    <label for="username" class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-10">
                        <input type="text"  class="form-control user-name" name="username" placeholder="用户昵称">
                    </div>
                    <div class="user-lack">
                        <p>请输入用户名！</p>
                    </div>
                    <div class="user-error">
                        <p>该用户名已存在</p>
                    </div>
                    <div class="user-success">
                        <p>该用户名可用！</p>
                  </div>
                </div>
                <!--用户名填写-->

                <div class="form-group">
                    <label for="" class="col-sm-2 control-label pass-code">设置密码</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control js-pass-code" name="setpassword" placeholder="密码为4-16位数字、字母组合">
                    </div>
                    <div class="pass-error"><p>密码格式错误！</p></div>
                </div>
                <!--//设置密码-->

                <div class="form-group">
                    <label for="" class="col-sm-2 control-label">确认密码</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control u-code" name="checkpassword" placeholder="与设置密码一致">
                    </div>
                    <div class="u-code-error"><p>请保持确认密码与设置密码一致！</p></div>
                </div>
                <!--//确认密码-->

                <div class="form-group">
                    <label for="" class="col-sm-2 control-label">手机号</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control mobile" name="mobilephone" placeholder="请输入手机号码">
                    </div>
                    <div class="mobile-error"><p>请输入正确的手机号码！</p></div>
                </div>
                <!--手机-->

                <div class="form-group">
                    <div class="Verification-code">
                        <div class="label-code"><label for="code">验证码</label></div>
                        <div class="input-code">
                            <input type="text" name="code" id="code"placeholder="4位验证码">
                        </div>
                        <div>
                            <img src="/WLSYS/servlet/CodeServlet" onclick="changeValidateCode(this)" class="img-style" />
                        </div>
                        <%--<div class="a-code"><a class="toVerification-code" tabindex="-1"href="javascript:">获取验证码</a></div>--%>
                    </div>
                </div>
                <div class="yzmtips" style="color:red"></div>
                <div class="empty-code"><p>请输入验证码！</p></div>
                <!--验证-->

                <div class="form-group">
                    <div></div>
                    <div class="col-sm-offset-2 col-sm-10">
                        <div class="user"><p>请输入用户名！</p></div>
                        <div class="pass"><p>请输入设置的密码！</p></div>
                        <div class="u"><p>请输入确认密码！</p></div>
                        <div class="number"><p>请输入手机号码！</p></div>
                        <div class="vcode"><p>请输入验证码！</p></div>
                        <div class="submit">
                            <button type="submit" class="btn  btn-default js-sub">注册</button>
                           <%-- <script>
                                function tz(){
                                    window.location.href='userLogin.jsp';
                                }
                            </script>--%>
                        </div>
                    </div>
                </div>
                <!--//注册（提交按钮）-->
            </form>
        </div>
    </div>
</div>
<script type="text/javascript" src="../js/jquery-2.2.0.js"></script>
<script type="text/javascript" src="../js/userRegister.js"></script>
</body>
</html>