<%--
  Created by IntelliJ IDEA.
  User: 牟国宏
  Date: 2016/1/29 0029
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet"href="../css/userLogin.css">
</head>
<body>
<div class="login">
    <div class="panel panel-default">
        <div class="panel-heading">用户登陆</div>
        <div class="panel-body login-in">
            <form class="form-horizontal" action="/WLSYS/UserLogin" method="post">
                <div class="form-group">
                    <!-- <div class="user_name"> -->
                    <label class="sr-only" for="exampleInputEmail3">用户名</label>
                    <input type="text" class="form-control user-name" id="exampleInputEmail3" placeholder="用户昵称" name="username">
                    <!-- </div> -->
                    <div class="user-lack">
                        <p>请输入用户名！</p>
                    </div>
                    <div class="user-error"> <p>该用户名不存在</p></div>
                    <!-- ajax之后才能用 -->
                </div>
                <!--用户名填写-->
                <div class="form-group">
                    <!-- <div class="user_code"> -->
                    <label class="sr-only " for="exampleInputPassword3">用户密码</label>
                    <input type="password" class="form-control js-pass-code" name="password" id="exampleInputPassword3" placeholder="用户密码">
                    <div class="pass-lack"><p>请输入密码！</p></div>
                    <div class="pass-error"><p>密码错误！</p></div>  <!-- ajax之后才能用 -->
                    <!-- </div> -->
                </div>
                <div class="form-group">
                    <div class="login-remember">
                        <div class="remember-code">
                            <div class="col-sm-offset-2 col-sm-10">
                                <div class="checkbox">
                                    <label><input type="checkbox" > 记住密码</label>
                                </div>
                            </div>
                        </div>
                        <!--记住密码-->
                        <div class="remember-login">
                            <div class="col-sm-offset-2 col-sm-10">
                                <div class="checkbox">
                                    <label><a href="">忘记密码?</a></label>
                                </div>
                            </div>
                        </div>
                        <!-- 忘记密码 -->
                        <!-- 自动登陆 btn-default-->
                    </div>
                </div>
                <div class="form-group">
                    <div class="user"><p>请输入用户名！</p></div>
                    <div class="pass"><p>请输入密码！</p></div>
                    <div class="signin">
                        <button type="submit" class="btn btn-default btn-block js-sub">登陆</button>
                    </div>
                </div>

            </form>
            <div class="panel-body">
                新用户<a href="userRegister.jsp">注册</a>
            </div>
        </div>
    </div>
</div>
        <script type="text/javascript" src="../js/jquery-2.2.0.js"></script>
        <script type="text/javascript" src="../js/userLogin.js"></script>
</body>
</html>
