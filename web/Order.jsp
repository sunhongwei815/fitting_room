<%@ page import="com.wlw.domain.Order" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<table style="border:1px solid grey;width:200px;height:50px;">
    <% List<Order> orders = (List<Order>) request.getAttribute("orders");
        for(int i = 0;i< orders.size();i++){%>
    <tr style="border:1px solid grey;width:200px;height:50px;">
        <td><%=orders.get(i).getOrder_no()%></td>
        <td><%=orders.get(i).getSource_id()%></td>
        <td><%=orders.get(i).getCommodity_link()%></td>
        <td><%=orders.get(i).getCommodity_decribe()%></td>
        <td><%=orders.get(i).getCommodity_count()%></td>
        <td><%=orders.get(i).getUser_id()%></td>
        <td><%=orders.get(i).getOrder_state()%></td>
        <td><%=orders.get(i).getPrice()%></td>
        <td><%=orders.get(i).getSumprice()%></td>
        <td><%=orders.get(i).getOrder_time()%></td>
        <td><%=orders.get(i).getArrival_time()%></td>
        <td><%=orders.get(i).getFinish_time()%></td>
        <td><%=orders.get(i).getApplyreturn_time()%></td>
        <td><%=orders.get(i).getFinishreturn_time()%></td>
        <td><%=orders.get(i).getOrder_id()%></td>
    </tr>
    <%}%>
</table>
</body>
</html>