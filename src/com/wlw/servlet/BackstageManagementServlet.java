package com.wlw.servlet;

import com.wlw.dao.OrderDao;
import com.wlw.dao.OrderlogDao;
import com.wlw.domain.Orderlog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2016/1/29.
 */
public class BackstageManagementServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //type从哪来，难道还从url中获得吗，按理应该从管理员点击后台管理页面相应的按钮中来，这是怎么链接的
        String type = req.getParameter("type");
        /*String type1 = req.getParameter("type1");*/
        OrderlogDao orderlogDao = new OrderlogDao();
        OrderDao orderDao = new OrderDao();
        //1-未审核订单；2-已审核订单；3-已下单；4-已到货；5-已完成；6-申请退货；7-退货中；8-退货完成
        if ("1".equals(type)) {
            //分审核通过和不通过
            /*if ("审核不通过".equals(type1)) {
                resp.sendRedirect("WLSYJ/web/WEB-INF/indes.jsp");
            } else if ("审核通过".equals(type1)) {*/
            String sql = "UPDATE `order` SET order_state='已审核订单' WHERE order_id=" + req.getParameter("order_id");
            try {
                orderDao.excuteUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Orderlog orderlog = new Orderlog();
            orderlog.setOrder_id(Integer.parseInt(req.getParameter("order_id")));
            orderlog.setOperator(req.getParameter("operator"));
            orderlog.setOperate_type("2");
            Date curDate = null;
            /*try {
                curDate = new SimpleDateFormat("yyyy-mm-dd").parse(req.getParameter("operate_time"));
            } catch (ParseException e) {
                e.printStackTrace();
            }*/
            java.sql.Date date = new java.sql.Date(new Date().getTime());
            orderlog.setOperate_time(date);
            try {
                orderlogDao.addOrderlog(orderlog);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            resp.sendRedirect("test5");

                        /*}*/
        } else if ("2".equals(type)) {

            String sql = "UPDATE `order` SET order_state='已下单' WHERE order_id=" + req.getParameter("order_id");
            try {
                orderDao.excuteUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Orderlog orderlog = new Orderlog();
            orderlog.setOrder_id(Integer.parseInt(req.getParameter("order_id")));
            orderlog.setOperator(req.getParameter("operator"));
            orderlog.setOperate_type("3");
           /* Date curDate = null;
            try {
                curDate = new SimpleDateFormat("yyyy-mm-dd").parse(req.getParameter("operate_time"));
            } catch (ParseException e) {
                e.printStackTrace();
            }*/
            java.sql.Date date = new java.sql.Date(new Date().getTime());
            orderlog.setOperate_time(date);
            try {
                orderlogDao.addOrderlog(orderlog);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            resp.sendRedirect("test5");

        } else if ("3".equals(type)) {
            String sql = "UPDATE `order` SET order_state='已到货' WHERE order_id=" + req.getParameter("order_id");
            try {
                orderDao.excuteUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Orderlog orderlog = new Orderlog();
            orderlog.setOrder_id(Integer.parseInt(req.getParameter("order_id")));
            orderlog.setOperator(req.getParameter("operator"));
            orderlog.setOperate_type("4");
           /* Date curDate = null;
            try {
                curDate = new SimpleDateFormat("yyyy-mm-dd").parse(req.getParameter("operate_time"));
            } catch (ParseException e) {
                e.printStackTrace();
            }*/
            java.sql.Date date = new java.sql.Date(new Date().getTime());
            orderlog.setOperate_time(date);
            try {
                orderlogDao.addOrderlog(orderlog);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            resp.sendRedirect("test5");
        } else if ("4".equals(type)) {

            String sql = "UPDATE `order` SET order_state='已完成' WHERE order_id=" + req.getParameter("order_id");
            try {

                orderDao.excuteUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Orderlog orderlog = new Orderlog();
            orderlog.setOrder_id(Integer.parseInt(req.getParameter("order_id")));
            orderlog.setOperator(req.getParameter("operator"));
            orderlog.setOperate_type("5");
            /*Date curDate = null;
            try {
                curDate = new SimpleDateFormat("yyyy-mm-dd").parse(req.getParameter("operate_time"));
            } catch (ParseException e) {
                e.printStackTrace();
            }*/
            java.sql.Date date = new java.sql.Date(new Date().getTime());
            orderlog.setOperate_time(date);
            try {
                orderlogDao.addOrderlog(orderlog);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            resp.sendRedirect("test5");
        } else if ("6".equals(type)) {

            String sql = "UPDATE `order` SET order_state=7 WHERE order_id=" + req.getParameter("order_id");
            try {
                orderDao.excuteUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Orderlog orderlog = new Orderlog();
            orderlog.setOrder_id(Integer.parseInt(req.getParameter("order_id")));
            orderlog.setOperator(req.getParameter("operator"));
            orderlog.setOperate_type("7");
            Date curDate = null;
            try {
                curDate = new SimpleDateFormat("yyyy-mm-dd").parse(req.getParameter("operate_time"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            java.sql.Date date = new java.sql.Date(curDate.getTime());
            orderlog.setOperate_time(date);
            try {
                orderlogDao.addOrderlog(orderlog);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else if ("7".equals(type)) {

            String sql = "UPDATE `order` SET order_state=8 WHERE order_id=" + req.getParameter("order_id");
            try {

                orderDao.excuteUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Orderlog orderlog = new Orderlog();
            orderlog.setOrder_id(Integer.parseInt(req.getParameter("order_id")));
            orderlog.setOperator(req.getParameter("operator"));
            orderlog.setOperate_type("8");
            Date curDate = null;
            try {
                curDate = new SimpleDateFormat("yyyy-mm-dd").parse(req.getParameter("operate_time"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            java.sql.Date date = new java.sql.Date(curDate.getTime());
            orderlog.setOperate_time(date);
            try {
                orderlogDao.addOrderlog(orderlog);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
