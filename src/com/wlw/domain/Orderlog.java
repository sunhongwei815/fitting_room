package com.wlw.domain;

import java.sql.Date;

/**
 * Created by linpeng123l on 16/1/23.
 */
public class Orderlog {

    private int orderlog_id;
    private int order_id;
    private String operator;
    private String operate_type;
    private Date operate_time;

    public int getOrderlog_id() {
        return orderlog_id;
    }

    public void setOrderlog_id(int orderlog_id) {
        this.orderlog_id = orderlog_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperate_type() {
        return operate_type;
    }

    public void setOperate_type(String operate_type) {
        this.operate_type = operate_type;
    }

    public Date getOperate_time() {
        return operate_time;
    }

    public void setOperate_time(Date operate_time) {
        this.operate_time = operate_time;
    }
}


