package com.wlw.servlet;

import com.alibaba.fastjson.JSONObject;
import com.wlw.dao.OrderDao;
import com.wlw.domain.Order;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;



public class OrderServlet extends HttpServlet {
    Order order = new Order();
    OrderDao orderDao = new OrderDao();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String type = request.getParameter("type");
        if ("add".equals(type)) {
            add(request, response);
        }else if
                ("queryAll".equals(type)) {
            queryAll(request, response);
        }
        HttpSession session = request.getSession();
        Integer NO = (Integer)session.getAttribute("NO");
        if(NO==null){
            NO = 1;
        }else{
            NO=NO.intValue()+1;
        }
        session.setAttribute("NO",NO);
        PrintWriter out = response.getWriter();
        out.println(NO);

    }
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");

        String source_id=request.getParameter("source_id");
        String commodity_link=request.getParameter("commodity_link");
        String commodity_decribe=request.getParameter("commodity_decribe");
        java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());


//        String commodity_count=request.getParameter("commodity_count");
//        String price=request.getParameter("price");



        if(username!=null){
            String regex="^(http(s)?:\\/\\/)?(www\\.)?[\\w-]+\\.\\w{2,4}(\\/)?$";
            if((source_id!=null)&&(commodity_link!=null)&&(commodity_decribe!=null)&&(commodity_link.matches(regex))) {
               OrderDao orderDao=new OrderDao();
                try {
                    String order_no = orderDao.queryOrder_no();
                    order.setOrder_no(order_no);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                order.setSource_id(Integer.parseInt(source_id));
                order.setCommodity_link(commodity_link);
                order.setCommodity_decribe(commodity_decribe);
                order.setCommodity_count(1);
                order.setUser_id((Integer)session.getAttribute("user_id"));//session
                order.setOrder_state("待审核");
                order.setPrice(10);
                order.setSumprice(10);
                order.setOrder_time(currentDate);
                order.setArrival_time(null);
                order.setFinish_time(null);
                order.setApplyreturn_time(null);
                order.setFinishreturn_time(null);
            }else {
                JSONObject jsonObject  = new JSONObject ();
                jsonObject.put("success","false");
                jsonObject.put("msg","添加失败");
                response.getWriter().write(jsonObject.toJSONString());
            }
        }else{
            JSONObject jsonObject  = new JSONObject ();
            jsonObject.put("success","false");
            jsonObject.put("msg","请登录");
            response.getWriter().write(jsonObject.toJSONString());
            response.sendRedirect("jsp/userLogin.jsp");



        }
        try {
            orderDao.add(order);
            JSONObject jsonObject  = new JSONObject ();
            jsonObject.put("success","true");
            jsonObject.put("msg","添加成功");
            response.getWriter().write(jsonObject.toJSONString());
        } catch (SQLException e) {
            e.printStackTrace();
            JSONObject jsonObject  = new JSONObject ();
            jsonObject.put("success","false");
            jsonObject.put("msg","添加失败");
            response.getWriter().write(jsonObject.toJSONString());

        }
    }
    public List<Order> queryAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Order> orders =orderDao.queryAll();
            request.setAttribute("orders",orders);
            request.getRequestDispatcher("Order.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}