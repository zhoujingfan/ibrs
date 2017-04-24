package com.buptsse.ibrs.model;



public class UserAndEnterprise {
    private Integer followId;

    private UserInfo userId;

    private Enterprise enterpriseId;

    private String addTime;

    private boolean ifLeave;
    
    private String leaveTime;



	public UserInfo getUserId() {
		return userId;
	}

	public Integer getFollowId() {
		return followId;
	}

	public void setFollowId(Integer followId) {
		this.followId = followId;
	}

	public void setUserId(UserInfo userId) {
		this.userId = userId;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public Enterprise getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(Enterprise enterpriseId) {
		this.enterpriseId = enterpriseId;
	}


	public boolean isIfLeave() {
		return ifLeave;
	}

	public void setIfLeave(boolean ifLeave) {
		this.ifLeave = ifLeave;
	}

	public String getLeaveTime() {
		return leaveTime;
	}

	public void setLeaveTime(String leaveTime) {
		this.leaveTime = leaveTime;
	}


}