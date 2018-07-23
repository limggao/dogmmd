package com.tjekuaitong.entity;

public class Pay {

	private Integer id;
	private String facePrice;
	private String orderCost;
	private String type;
	private String classId;
	private String pageIndex;
	private String pageSize;
	
	public String getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(String pageIndex) {
		this.pageIndex = pageIndex;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFacePrice() {
		return facePrice;
	}
	public void setFacePrice(String facePrice) {
		this.facePrice = facePrice;
	}
	public String getOrderCost() {
		return orderCost;
	}
	public void setOrderCost(String orderCost) {
		this.orderCost = orderCost;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	@Override
	public String toString() {
		return "pay [id=" + id + ", facePrice=" + facePrice + ", orderCost="
				+ orderCost + ", type=" + type + ", classId=" + classId + "]";
	}
	
	
	
	
}
