package com.buptsse.ibrs.model;

import java.util.Date;

public class Invoice {
    private Integer id;

    private Integer invoiceId;

    private Integer invoiceNumber;

    private Integer password;
    
    private String payEnterprise;

    private String taxNumber;

    private Integer cnInvoicecol;

    private Date payData;

    private Integer payee;

    private Integer payer;

    private String details;

    private Integer paySum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    
    public Integer getPassword() {
		return password;
	}

	public void setPassword(Integer password) {
		this.password = password;
	}

	public Integer getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(Integer invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getPayEnterprise() {
        return payEnterprise;
    }

    public void setPayEnterprise(String payEnterprise) {
        this.payEnterprise = payEnterprise == null ? null : payEnterprise.trim();
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber == null ? null : taxNumber.trim();
    }

    public Integer getCnInvoicecol() {
        return cnInvoicecol;
    }

    public void setCnInvoicecol(Integer cnInvoicecol) {
        this.cnInvoicecol = cnInvoicecol;
    }

    public Date getPayData() {
        return payData;
    }

    public void setPayData(Date payData) {
        this.payData = payData;
    }

    public Integer getPayee() {
        return payee;
    }

    public void setPayee(Integer payee) {
        this.payee = payee;
    }

    public Integer getPayer() {
        return payer;
    }

    public void setPayer(Integer payer) {
        this.payer = payer;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }

    public Integer getPaySum() {
        return paySum;
    }

    public void setPaySum(Integer paySum) {
        this.paySum = paySum;
    }
}