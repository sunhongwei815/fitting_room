package com.wlw.dao;

import com.wlw.domain.Orderlog;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunshuli on 16/1/23.
 */
public class OrderlogDao extends BaseDao {

    //添加一条记录到数据库
    public void addOrderlog(Orderlog orderlog) throws SQLException {
        //得到当前链接
        Connection connection = getCurrentConnection();
        //启动线程事件
        beginThreadTransaction();
        //创建一个 PreparedStatement 对象来将参数化的 SQL 语句发送到数据库
        PreparedStatement ps = connection.prepareStatement("insert into orderlog (order_id,operator,operate_type,operate_time) values(?,?,?,?)");
        //将指定参数设置为给定 Java String 值

        ps.setInt(1,orderlog.getOrder_id());
        ps.setString(2,orderlog.getOperator());
        ps.setString(3,orderlog.getOperate_type());
        ps.setDate(4,orderlog.getOperate_time());

          // 在此 PreparedStatement 对象中执行 SQL 语句
        ps.executeUpdate();
        commitThreadTransaction();
        //关闭当前声明和链接
        closePreparedStatement(ps);
        closeConnection(connection);
    }

    //按照主键删除数据库中的一条记录
    public void deleteById(int id) throws SQLException {
        //获得当前链接
        Connection connection = getCurrentConnection();
        //创建一个 PreparedStatement 对象来将参数化的 SQL 语句发送到数据库（此处是按主键删除）
        String sql = "DELETE from orderlog where orderlog_id = " + id;
        PreparedStatement ps = connection.prepareStatement(sql);
        //在此 PreparedStatement 对象中执行 SQL 查询，并返回该查询生成的 ResultSet 对象
        ps.executeUpdate();
        //关闭链接、声明
        closePreparedStatement(ps);
        closeConnection(connection);
    }
    //按照主键查询一条记录
    public Orderlog findById(int id) throws SQLException {
        Orderlog orderlog = new Orderlog();
        //获得当前链接
        Connection connection = getCurrentConnection();
        //创建一个 PreparedStatement 对象来将参数化的 SQL 语句发送到数据库（此处是按主键查询）
        String sql = "select * from orderlog where orderlog_id = " + id;
        PreparedStatement ps = connection.prepareStatement(sql);
        //在此 PreparedStatement 对象中执行 SQL 查询，并返回该查询生成的 ResultSet 对象
        ResultSet rs = ps.executeQuery();
        //从结果集中把各字段值取出来赋值给声明的相应属性
        while (rs.next()) {
            orderlog.setOrder_id(rs.getInt("order_id"));
            orderlog.setOperator(rs.getString("operator"));
            orderlog.setOperate_type(rs.getString("operate_type"));
            orderlog.setOperate_time(rs.getDate("operate_time"));
        }
        //关闭链接、声明和结果集
        closeAll(connection, ps, rs);
        //返回查询到的一条orderlog记录
        return orderlog;
    }


    //查询数据库中的所有记录添加到orderlogs数组链表中
    public List<Orderlog> queryAllOrderlog() throws SQLException {
        //新建一个数组链表，数组大小可变
        List<Orderlog> orderlogs = new ArrayList<Orderlog>();
        //获得当前链接
        Connection connection = getCurrentConnection();
        //创建一个 PreparedStatement 对象来将参数化的 SQL 语句发送到数据库（此处是查询全部）
        PreparedStatement ps = connection.prepareStatement("select *from orderlog");
        //在此 PreparedStatement 对象中执行 SQL 查询，并返回该查询生成的 ResultSet 对象
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            //把结果集中获得的每一条记录封装成一个orderlog对象，并对对象的各属性读值
            Orderlog orderlog = new Orderlog();
            orderlog.setOrderlog_id(rs.getInt("orderlog_id"));
            orderlog.setOrder_id(rs.getInt("order_id"));
            orderlog.setOperator(rs.getString("operator"));
            orderlog.setOperate_type(rs.getString("operate_type"));
            orderlog.setOperate_time(rs.getDate("operate_time"));
            //把所有的orderlog对象添加到orderlogs数组链表中
            orderlogs.add(orderlog);
        }
        //关闭链接、声明和结果集
        closeAll(connection, ps, rs);
        //返回orderlogs数组链表
        return orderlogs;
    }


}


