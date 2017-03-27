package com.buptsse.ibrs.model;

import java.util.Date;

public class Enterprise {
    private Integer id;

    private String enterpriseName;

    private String enterpriseNumber;

    private String enterpriseAddress;

    private Integer certigier;

    private String password;
    
    private Date date;

    private String licenseNumber;
    
    public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumbwe(String licenseNumbwe) {
		this.licenseNumber = licenseNumbwe;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName == null ? null : enterpriseName.trim();
    }

    public String getEnterpriseNumber() {
        return enterpriseNumber;
    }

    public void setEnterpriseNumber(String enterpriseNumber) {
        this.enterpriseNumber = enterpriseNumber == null ? null : enterpriseNumber.trim();
    }

    public String getEnterpriseAddress() {
        return enterpriseAddress;
    }

    public void setEnterpriseAddress(String enterpriseAddress) {
        this.enterpriseAddress = enterpriseAddress == null ? null : enterpriseAddress.trim();
    }

    public Integer getCertigier() {
        return certigier;
    }

    public void setCertigier(Integer certigier) {
        this.certigier = certigier;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}