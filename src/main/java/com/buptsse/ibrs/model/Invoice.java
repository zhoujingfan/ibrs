package com.buptsse.ibrs.model;


public class Invoice {
    private long invoiceId;

    private long number;

    private long taxNumber;

    private String password;
    
    private String payEnterprise;

    private String payData;

    private String payee;

    private String payer;

    private String details;

    private Integer paySum;

	public long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public long getTaxNumber() {
		return taxNumber;
	}

	public void setTaxNumber(long taxNumber) {
		this.taxNumber = taxNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPayEnterprise() {
		return payEnterprise;
	}

	public void setPayEnterprise(String payEnterprise) {
		this.payEnterprise = payEnterprise;
	}

	public String getPayData() {
		return payData;
	}

	public void setPayData(String payData) {
		this.payData = payData;
	}

	public String getPayee() {
		return payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public String getPayer() {
		return payer;
	}

	public void setPayer(String payer) {
		this.payer = payer;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Integer getPaySum() {
		return paySum;
	}

	public void setPaySum(Integer paySum) {
		this.paySum = paySum;
	}

}