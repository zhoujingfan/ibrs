package com.buptsse.ibrs.model;


public class InvoiceExpense {
	
	private long uploadId;
	
    private UserInfo uploadUser;

    private String uploadTime;

    private Enterprise uploadEnterprise;

    private Integer ifRight;

    private Integer ifExpense;

    private Integer ifRepetition;


	private Invoice invoice;
    
    private String massage;

    

    public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}
	
	public String getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}

	public long getUploadId() {
		return uploadId;
	}

	public void setUploadId(long uploadId) {
		this.uploadId = uploadId;
	}



	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public UserInfo getUploadUser() {
		return uploadUser;
	}

	public void setUploadUser(UserInfo uploadUser) {
		this.uploadUser = uploadUser;
	}

	public Enterprise getUploadEnterprise() {
		return uploadEnterprise;
	}

	public void setUploadEnterprise(Enterprise uploadEnterprise) {
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