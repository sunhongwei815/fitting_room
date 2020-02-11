package com.wlw.servlet;

import com.alibaba.fastjson.JSONObject;
import com.wlw.dao.SourceDao;
import com.wlw.domain.Source;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;


/**
 * Created by 牟国宏 on 2016/1/24 0024.
 */
public class SourceServlet extends HttpServlet {
    Source source = new Source();
    SourceDao sourceDao = new SourceDao();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String type = request.getParameter("type");
        recordSource(request,response);
        if ("addSource".equals(type)) {
            addSource(request, response);
        } else if ("queryAllSource".equals(type)) {
            queryAllSource(request, response);
        }

    }

    /*
     * 从浏览器添加数据到数据库
     * */
    private void addSource(HttpServletRequest request, HttpServletResponse response) {

        String source_name = request.getParameter("source_name");
        Integer source_id = Integer.parseInt(request.getParameter("source_id"));
        source.setSource_name(source_name);
        source.setSource_id(source_id);
        try {
            if (source_id.equals(0) || ("".equals(source_name) || source_name == null)) {
                response.getWriter().print("fail");
            } else {
                response.sendRedirect("SourceServletTest?type=queryAllSource");
            }
            sourceDao.add(source);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
        *
        * 查询数据并显示在浏览器
        * */
    private void queryAllSource(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            SourceDao sourceDao = new SourceDao();
            List<Source> sources = sourceDao.queryAllTests();
            JSONObject jsonObject  = new JSONObject();
            jsonObject.put("root", sources);
            PrintWriter out = response.getWriter();
            out.print(jsonObject);
            /*request.setAttribute("sources", sources);
            request.getRequestDispatcher("index.jsp").forward(request, response);*/
        } catch (SQLException e) {
            response.getWriter().print("数据库数据异常！");
        }
    }
    /*
    *
    * 记录访问浏览器的次数
    * */
    private void recordSource(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        System.out.println(session);
        String heading;
        Integer count =(Integer) session.getAttribute("count");
        if(count == null) {
            count = new Integer(0);
            heading = "Welcom,You are first time to visit!";
        }
        else {
            heading = "Welcome Backer";
            count = new Integer(count.intValue()+1);
        }
        session.setAttribute("count",count);
    }
}