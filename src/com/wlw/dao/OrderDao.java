package com.wlw.dao;

import com.wlw.domain.Order;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
public class OrderDao extends BaseDao {
    public void add(Order order)throws SQLException {
        java.sql.Connection connection=getCurrentConnection();
        PreparedStatement ps =connection.prepareStatement( "INSERT into `order`(order_no,source_id,commodity_link,commodity_decribe," +
                "commodity_count,user_id,order_state,price,sumprice," +
                "order_time,arrival_time,finish_time,applyreturn_time,finishreturn_time) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

        ps.setString(1,order.getOrder_no());
        ps.setInt(2,order.getSource_id());
        ps.setString(3,order.getCommodity_link());
        ps.setString(4,order.getCommodity_decribe());
        ps.setInt(5,order.getCommodity_count());
        ps.setInt(6,order.getUser_id());
        ps.setString(7,order.getOrder_state());
        ps.setFloat(8,order.getPrice());
        ps.setFloat(9,order.getSumprice());
        ps.setDate(10,order.getOrder_time());
        ps.setDate(11,order.getArrival_time());
        ps.setDate(12,order.getFinish_time());
        ps.setDate(13,order.getApplyreturn_time());
        ps.setDate(14,order.getFinishreturn_time());
        ps.executeUpdate();
        closePreparedStatement(ps);
        closeConnection(connection);
    }
    public void deleteByOrder_Id(int order_id) throws SQLException{
        java.sql.Connection connection=getCurrentConnection();
        PreparedStatement ps = connection.prepareStatement("DELETE FROM order WHERE order_id=?");
        ps.setInt(1,order_id);
        ps.executeUpdate();
        closePreparedStatement(ps);
        closeConnection(connection);
    }
    public Order queryByOrder_id(int order_id) throws SQLException {
        String sql = "SELECT * FROM order WHERE order_id = ?" ;
        java.sql.Connection connection = getCurrentConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,order_id);
        Order order=new Order();
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            order.setOrder_no(rs.getString("order_no"));
            order.setSource_id(rs.getInt("source_id"));
            order.setCommodity_link(rs.getString("commodity_link;"));
            order.setCommodity_decribe(rs.getString("commodity_decribe"));
            order.setCommodity_count(rs.getInt("commodity_count"));
            order.setUser_id(rs.getInt("user_id"));
            order.setOrder_state(rs.getString("order_state"));
            order.setPrice(rs.getFloat("price"));
            order.setSumprice(rs.getFloat("sumprice"));
            order.setOrder_time(rs.getDate("order_time"));
            order.setArrival_time(rs.getDate("arrival_time"));
            order.setFinish_time(rs.getDate("finish_time"));
            order.setApplyreturn_time(rs.getDate("applyreturn_time"));
            order.setFinishreturn_time(rs.getDate("finishreturn_time"));
        }
        closeAll(connection, ps, rs);
        return order;
    }
    public List<Order> queryAll()throws SQLException {
        List<Order> orders = new ArrayList<Order>();
        java.sql.Connection connection = getCurrentConnection();
        PreparedStatement ps = connection.prepareStatement("select * from `order`");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Order order = new Order();
            order.setOrder_no(rs.getString("order_no"));
            order.setSource_id(rs.getInt("source_id"));
            order.setCommodity_link(rs.getString("commodity_link"));
            order.setCommodity_decribe(rs.getString("commodity_decribe"));
            order.setCommodity_count(rs.getInt("commodity_count"));
            order.setUser_id(rs.getInt("user_id"));
            order.setOrder_state(rs.getString("order_state"));
            order.setPrice(rs.getFloat("price"));
            order.setSumprice(rs.getFloat("sumprice"));
            order.setOrder_time(rs.getDate("order_time"));
            order.setArrival_time(rs.getDate("arrival_time"));
            order.setFinish_time(rs.getDate("finish_time"));
            order.setApplyreturn_time(rs.getDate("applyreturn_time"));
            order.setFinishreturn_time(rs.getDate("finishreturn_time"));
            order.setOrder_id(rs.getInt("order_id"));
            orders.add(order);
        }
        closeAll(connection, ps, rs);
        return orders;
    }

    public String queryOrder_no() throws SQLException{
        String order_no;
        List<Order> orders = new ArrayList<Order>();
        java.sql.Connection connection = getCurrentConnection();
          java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
          SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
          String date1 =sdf.format(currentDate);
        PreparedStatement ps = connection.prepareStatement("SELECT order_no FROM `order` where order_no LIKE '%"+date1+"%'");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Order order = new Order();
            order.setOrder_no(rs.getString("order_no"));
            orders.add(order);
        }
        int count = orders.size()+1;
        if(count==0){
            order_no=date1+"0001";
        }else{
            String str = new DecimalFormat("0000").format(count);
            order_no=date1+str;
        }
        return order_no;
    }
}

