package com.wlw.domain;



import java.sql.Date;

public class Order {

    private String order_no;
    private int source_id;
    private String commodity_link;
    private String commodity_decribe;
    private int commodity_count;
    private int user_id;
    private String order_state;
    private float price;
    private float sumprice;
    private java.sql.Date order_time;
    private Date arrival_time;
    private Date finish_time;
    private Date applyreturn_time;
    private Date finishreturn_time;
    private int order_id;

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public int getSource_id() {
        return source_id;
    }

    public void setSource_id(int source_id) {
        this.source_id = source_id;
    }

    public String getCommodity_link() {
        return commodity_link;
    }

    public void setCommodity_link(String commodity_link) {
        this.commodity_link = commodity_link;
    }

    public String getCommodity_decribe() {
        return commodity_decribe;
    }

    public void setCommodity_decribe(String commodity_decribe) {
        this.commodity_decribe = commodity_decribe;
    }

    public int getCommodity_count() {
        return commodity_count;
    }

    public void setCommodity_count(int commodity_count) {
        this.commodity_count = commodity_count;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getOrder_state() {
        return order_state;
    }

    public void setOrder_state(String order_state) {
        this.order_state = order_state;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getSumprice() {
        return sumprice;
    }

    public void setSumprice(float sumprice) {
        this.sumprice = sumprice;
    }

    public Date getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }

    public Date getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(Date arrival_time) {
        this.arrival_time = arrival_time;
    }

    public Date getFinish_time() {
        return finish_time;
    }

    public void setFinish_time(Date finish_time) {
        this.finish_time = finish_time;
    }

    public Date getApplyreturn_time() {
        return applyreturn_time;
    }

    public void setApplyreturn_time(Date applyreturn_time) {
        this.applyreturn_time = applyreturn_time;
    }

    public Date getFinishreturn_time() {
        return finishreturn_time;
    }

    public void setFinishreturn_time(Date finishreturn_time) {
        this.finishreturn_time = finishreturn_time;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }



}


