package com.centerorbit.AME.model;

/**
 * Created by joe on 1/7/14.
 */
public class Visit {
    private long visit_id;
    private int yard_id;
    private int user_id;
    private long colony_id;
    private int queen_status_id;
    private int queen_id;
    private String date_time_start;
    private String date_time_close;
    private int qty_deep;
    private int qty_super;

    public long getId() {return this.visit_id;}
    public void setId(long id) {this.visit_id = id;}

    public int getYardId() { return this.yard_id; }
    public void setYardId(int yard) {
        this.yard_id = yard;
    }

    public int getUserId() { return this.user_id;}
    public void setUserId(int id) {this.user_id = id;}

    public long getColonyId() {
        return this.colony_id;
    }
    public void setColonyId(long id) {
        this.colony_id = id;
    }

    public int getQueenId() {
        return this.queen_id;
    }
    public void setQueenId(int id) {this.queen_id = id;}

    public int getQueenStatusId() {return this.queen_status_id;}
    public void setQueenStatusId(int status) {this.queen_status_id = status;}

    public String getDate_time_start() {return this.date_time_start;}
    public void setDate_time_start(String date) {this.date_time_start = date;}

    public String getDate_time_close() {return this.date_time_close;}
    public void setDate_time_close(String date) {this.date_time_close = date;}

    public int getQtyDeep() { return this.qty_deep;}
    public void setQtyDeep(int qty) {this.qty_deep = qty;}

    public int getQtySuper() { return this.qty_super;}
    public void setQtySuper(int qty) {this.qty_super = qty;}


}
