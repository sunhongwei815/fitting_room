package com.wlw.servlet;


import com.wlw.dao.OrderlogDao;
import com.wlw.domain.Orderlog;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderlogServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    OrderlogDao orderlogDao=new OrderlogDao();
    //重写doGet方法
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //接收请求参数
        String type = request.getParameter("type");
              if("addOrderlog".equals(type)) {
                  try {
                      addOrderlog(request, response);
                      response.getWriter().print("success");
                  } catch (ParseException e) {
                      e.printStackTrace();
                      response.getWriter().print("fail");
                  }
              }else if("getAllOrderlogs".equals(type)) {
            getAllOrderlogs(request, response);
        }
    }

    private void getAllOrderlogs(HttpServletRequest request,HttpServletResponse response) throws IOException {
        List<Orderlog> orderlogs = null;
        try {
            orderlogs = orderlogDao.queryAllOrderlog();
            request.setAttribute("orderlogs",orderlogs);
            try {
                request.getRequestDispatcher("jsp/backManager.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
            /*JSONObject jsonObject = new JSONObject();
            jsonObject.put("root", orderlogs);
            ResponseUtil.print(response, jsonObject);*/
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().print("fail");
        }

    }

    private void addOrderlog(HttpServletRequest request,HttpServletResponse response) throws IOException, ParseException {
        Orderlog orderlog = new Orderlog();
        orderlog.setOrder_id(Integer.parseInt(request.getParameter("order_id")));
        orderlog.setOperator( request.getParameter("operator"));
        orderlog.setOperate_type(request.getParameter("operate_type"));
        java.util.Date curDate =  new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("operate_time"));
        java.sql.Date date=new java.sql.Date(curDate.getTime());
        orderlog.setOperate_time(date);


        try {
            orderlogDao.addOrderlog(orderlog);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        ResponseUtil.print(response, generateSuccessMsg("添加成功"));
//        response.sendRedirect("question/error/suveryFailSJ.html");
        }


//        //新建一个OrderlogDao类下的对象，用于调用其下的方法
//        OrderlogDao orderlogDao=new OrderlogDao();
//
//        try {
//            orderlogDao.queryAllOrderlog();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }

//try {
//    if (DaoFactory.getIOrderlogDAOInstance().findLogin(orderlog)) {
//      info.add("订单信息填写正确");
//  }
// }else{
//  info.add("订单日志填写错误");
//  }
// }catch(Exception e){
//        e.printStackTrace();
//      }
//  }
// req.setAttribute("info",info);
//跳转
//  req.getRequstDispatcher(path).forward(req,resp);