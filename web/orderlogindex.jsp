<%@ page import="java.util.List" %>
<%@ page import="com.wlw.domain.User" %>
<%@ page import="com.wlw.domain.Orderlog" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/1/23
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <table style="border:1px solid grey;width:300px;height:100px;">
    <%
      List<Orderlog> orderlogs = (List<Orderlog>) request.getAttribute("orderlogs");
    for(int i = 0;i< orderlogs.size();i++){%>
    <tr style="border:1px solid grey;width:300px;height:100px;">
      <td><%=orderlogs.get(i).getOrder_id()%></td>
      <td><%=orderlogs.get(i).getOperator()%></td>
      <td><%=orderlogs.get(i).getOperate_type()%></td>
      <td><%=orderlogs.get(i).getOperate_time()%></td>
    </tr>
    <%}%>
  </table>
  </body>
</html>
