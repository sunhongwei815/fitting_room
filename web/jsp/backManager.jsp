
<%@ page import="java.util.List" %>
<%@ page import="com.wlw.domain.Order" %><%--
  Created by IntelliJ IDEA.
  User: 牟国宏
  Date: 2016/1/30 0030
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<head>
    <title>后台管理</title>
    <link rel="stylesheet" href="/WLSYS/css/bootstrap.min.css">
    <link rel="stylesheet" href="/WLSYS/css/backManager.css">
</head>
<body>
    <div class="container">
        <div class="tab-content">
            <table class="table table-striped">
                <caption>后台管理界面</caption>
                <tr>
                    <th>订单编号</th>
                    <th>下单日期</th>
                    <th>下单人</th>
                    <th>下单链接</th>
                    <th>下单数量</th>
                    <th></th>
                </tr>
                <%
                    List<Order> orders = (List<Order>) request.getAttribute("orders");
                    for(int i = 0;i< orders.size();i++){%>
                <tr>
                    <td><%=orders.get(i).getOrder_id()%></td>
                    <td><%=orders.get(i).getOrder_time()%></td>
                    <td><%=orders.get(i).getUser_id()%></td>
                    <td><%=orders.get(i).getCommodity_link()%></td>
                    <td><%=orders.get(i).getCommodity_count()%></td>
                    <% String Order_state=orders.get(i).getOrder_state();%>
                    <td>
                        <%if("待审核".equals(Order_state)){%>
                        <a href="http://localhost:8080/WLSYS/test3?type=1&order_id=<%=orders.get(i).getOrder_id()%>"><button class="btn btn-default btn-size">审核</button></a>
                        <%}%>
                        <%if("已审核订单".equals(Order_state)){%>
                        <a href="http://localhost:8080/WLSYS/test3?type=2&order_id=<%=orders.get(i).getOrder_id()%>"><button class="btn btn-default btn-size">下单</button></a>
                        <%}%>
                        <%if("已下单".equals(Order_state)){%>
                        <a href="http://localhost:8080/WLSYS/test3?type=3&order_id=<%=orders.get(i).getOrder_id()%>"><button class="btn btn-default btn-size">接货</button></a>
                        <%}%>
                        <%if("已到货".equals(Order_state)){%>
                        <a href="http://localhost:8080/WLSYS/test3?type=4&order_id=<%=orders.get(i).getOrder_id()%>"><button class="btn btn-default btn-size">完成</button></a>
                        <%}%>
                        <%if("已完成".equals(Order_state)){%>
                        <button class="btn btn-default btn-size">已完成</button></a>
                        <%}%>
                       <%-- <%if("2".equals(Order_state)){%>--%>
                       <%-- <a href="http:localhost:8080/WLSYS/test3?type=6"><button class="btn btn-default btn-size">下单</button></a>
                        <%}%>
                        <%if("2".equals(Order_state)){%>
                        <a href="http:localhost:8080/WLSYS/test3?type=6"><button class="btn btn-default btn-size">下单</button></a>
                        <%}%>
                        <%if("2".equals(Order_state)){%>
                        <a href="http:localhost:8080/WLSYS/test3?type=6"><button class="btn btn-default btn-size">下单</button></a>
                        <%}%>--%>
                    </td>>
                </tr>
                <%}%>
            </table>
        </div>
    </div>
</body>