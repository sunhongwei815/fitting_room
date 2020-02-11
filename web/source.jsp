<%@ page import="com.wlw.domain.Source" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 牟国宏
  Date: 2016/1/28 0028
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Source表</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
    <h1> <span>number</span> :<%=session.getAttribute("count")%></h1>
    <table class="table-bordered">
        <tr style="width:200px;height:50px;border-bottom: 1px ;border-top: 1px;">
            <td style="width:100px;height:50px; text-align:center">source_id</td>
            <td style="width:100px;height:50px; text-align:center">source_name</td>
        </tr>
        <% List<Source> sources = (List<Source>) request.getAttribute("sources");
            for(int i=0;i<sources.size();i++){%>
        <tr style="width:200px;height:20px;border-bottom: 1px ;border-top: 1px;">
            <td style="boeder:1px solid grey;width:100px;height:30px; text-align:center;"><%=sources.get(i).getSource_id()%></td>
            <td style="boeder:1px solid grey;width:100px;height:30px; text-align:center;"><%=sources.get(i).getSource_name()%></td>
        </tr>
        <%}%>
    </table>
</body>
</html>
