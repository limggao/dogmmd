package com.tjekuaitong.entity;

public class VipUpdate {

	private Integer id;
	//添加的积分
	private String addVip;
	//修改的积分
	private String reduceVip;
	//添加修改积分时间
	private String vipUpdateTime;
	//总积分
	private String totalScore;
	//openId
	private String openId;
	
	//用户Id
	private String userId;
	
	private String type;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(String totalScore) {
		this.totalScore = totalScore;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAddVip() {
		return addVip;
	}
	public void setAddVip(String addVip) {
		this.addVip = addVip;
	}
	public String getReduceVip() {
		return reduceVip;
	}
	public void setReduceVip(String reduceVip) {
		this.reduceVip = reduceVip;
	}
	public String getVipUpdateTime() {
		return vipUpdateTime;
	}
	public void setVipUpdateTime(String vipUpdateTime) {
		this.vipUpdateTime = vipUpdateTime;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	
	
}
