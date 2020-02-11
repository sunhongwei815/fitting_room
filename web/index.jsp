<%--
  Created by IntelliJ IDEA.
  User: 牟国宏
  Date: 2016/1/29 0029
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/index.css">
</head>
<body>
<!--头部-->
<div class="top">
    <div class="top-content">
        <div class="brand">
            <span>工大试衣间</span>
        </div>
        <div class="content">
            <ul class="content-title">
                <li class="li-list">
                    <button class="btn btn-design"><a href="">首页</a></button>
                </li>
                <li class="li-list">
                    <button class="btn btn-design"><a href="">资源分享</a></button>
                </li>
                <li class="li-list">
                    <button class="btn btn-design"><a href="">关于我们</a></button>
                </li>
            </ul>
        </div>
        <div class="person">
            <span>个人中心</span>
        </div>
    </div>
</div>
<!--主体-->
<div class="container">
    <!--订单区-->
    <div class="order-content">
        <form action="Order?type=add" method="post" class="form-design">
            <div class="source-goods">
                <div class="pay-mode">
                    <label for="input-style" class="pro-label">商品来源</label>
                    <select name="source_id" id="input-style">
                        <option value="0">选择商家</option>
                    </select>
                </div>
                <div class="pay-address">
                    <input type="text" class="btn btn-desgin" id="input-netAddress" name="commodity_link" placeholder="请输入您的商品网址">
                </div>

            </div>
            <div class="empty-addr"><p>网购地址不能为空！</p></div>
            <div class="error-addr"><p>网购地址格式不正确！</p></div>
            <div class="decoration-goods">
                <label for="input-discribe" class="pro-declabel">商品描述</label>
                <span class="textarea-con">
                    <textarea name="commodity_decribe" class="text-area" id="input-discribe"></textarea>
                    <span class="count-txt"><span id="name-word">0</span>/100</span>
                </span>
                <div class="error-dis"><p>请输入对商品的描述！</p></div>
            </div>
            <div class="submit-goods">
                <div class="netaddr"><p>请输入您的商品的网址！</p> </div>
                <div class="pro-dis"><p>请输入您商品的描述！</p> </div>
                <div class="submit-content">
                    <input type="submit" class="btn btn-action" id="btn-submit" value="提交订单">
                </div>

            </div>
        </form>
    </div>
    <!--广告区-->
    <div class="ad-part">
        <!--广告图片第一列-->
        <div class="ad-list">
            <div class="ad-content">
                <div class="image">
                    <img src="" alt="">
                </div>
                <div class="text"></div>
            </div>
            <div class="ad-content">
                <div class="image">
                    <img src="" alt="">
                </div>
                <div class="text"></div>
            </div>
            <div class="ad-content">
                <div class="image">
                    <img src="" alt="">
                </div>
                <div class="text"></div>
            </div>
            <div class="ad-content">
                <div class="image">
                    <img src="" alt="">
                </div>
                <div class="text"></div>
            </div>
            <div class="ad-content">
                <div class="image">
                    <img src="" alt="">
                </div>
                <div class="text"></div>
            </div>
        </div>
        <!--广告图片第二列-->
        <div class="ad-list">
            <div class="ad-content">
                <div class="image">
                    <img src="" alt="">
                </div>
                <div class="text"></div>
            </div>
            <div class="ad-content">
                <div class="image">
                    <img src="" alt="">
                </div>
                <div class="text"></div>
            </div>
            <div class="ad-content">
                <div class="image">
                    <img src="" alt="">
                </div>
                <div class="text"></div>
            </div>
            <div class="ad-content">
                <div class="image">
                    <img src="" alt="">
                </div>
                <div class="text"></div>
            </div>
            <div class="ad-content">
                <div class="image">
                    <img src="" alt="">
                </div>
                <div class="text"></div>
            </div>
        </div>
    </div>
</div>
<!--尾部-->
<div class="foot">
    <div class="foot-content">
        <div class="btn-list">
            <input type="button" class="btn-design" value="工大首页">
        </div>
        <div class="btn-list">
            <input type="button" class="btn-design" value="实验室首页">
        </div>
        <div class="btn-list">
            <input type="button" class="btn-design" value="工大学子">
        </div>
    </div>
    <div class="footing"></div>
</div>
<script src="js/jquery-2.1.4.min.js"></script>
<script src="js/index.js"></script>
</body>
</html>