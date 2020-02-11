package com.wlw.servlet;

import com.wlw.dao.OrderDao;
import com.wlw.domain.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2016/1/31.
 */
public class OrderServlet2 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        OrderDao orderDao = new OrderDao();
        List<Order> orders = null;
        try {
            orders = orderDao.queryAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("jsp/backManager.jsp").forward(request, response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
