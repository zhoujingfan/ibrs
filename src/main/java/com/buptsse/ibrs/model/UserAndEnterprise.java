package com.buptsse.ibrs.model;

import java.util.Date;

public class UserAndEnterprise {
    private Integer id;

    private Integer userid;

    private Integer enterprise;

    private Date date;

    private Integer ifLeave;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Integer enterprise) {
        this.enterprise = enterprise;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getIfLeave() {
        return ifLeave;
    }

    public void setIfLeave(Integer ifLeave) {
        this.ifLeave = ifLeave;
    }
}