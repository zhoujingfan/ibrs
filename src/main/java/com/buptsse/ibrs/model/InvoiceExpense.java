package com.buptsse.ibrs.model;

import java.util.Date;

public class InvoiceExpense extends InvoiceExpenseKey {
    private Integer uploadUser;

    private Date uploadDate;

    private Integer uploadEnterprise;

    private Integer ifRight;

    private Integer ifExpense;

    private Integer ifRepetition;

    public Integer getUploadUser() {
        return uploadUser;
    }

    public void setUploadUser(Integer uploadUser) {
        this.uploadUser = uploadUser;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Integer getUploadEnterprise() {
        return uploadEnterprise;
    }

    public void setUploadEnterprise(Integer uploadEnterprise) {
        this.uploadEnterprise = uploadEnterprise;
    }

    public Integer getIfRight() {
        return ifRight;
    }

    public void setIfRight(Integer ifRight) {
        this.ifRight = ifRight;
    }

    public Integer getIfExpense() {
        return ifExpense;
    }

    public void setIfExpense(Integer ifExpense) {
        this.ifExpense = ifExpense;
    }

    public Integer getIfRepetition() {
        return ifRepetition;
    }

    public void setIfRepetition(Integer ifRepetition) {
        this.ifRepetition = ifRepetition;
    }
}