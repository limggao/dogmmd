package com.tjekuaitong.entity;

import java.util.List;

public class ViewProductGradeType<T> {

	private Integer product_id;
	private String product_name;//商品名称
	private String product_desc;//商品说明
	private Integer product_type;//商品种类
	private Integer product_grade;//商品分类
	private Integer product_price;//商品单价金额
	private Integer product_num;//商品数量
	private String drade_name;//分类名称
	private String type_name;//类别名称
	private List<T> children;
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_desc() {
		return product_desc;
	}
	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}
	public Integer getProduct_type() {
		return product_type;
	}
	public void setProduct_type(Integer product_type) {
		this.product_type = product_type;
	}
	public Integer getProduct_grade() {
		return product_grade;
	}
	public void setProduct_grade(Integer product_grade) {
		this.product_grade = product_grade;
	}
	public Integer getProduct_price() {
		return product_price;
	}
	public void setProduct_price(Integer product_price) {
		this.product_price = product_price;
	}
	public Integer getProduct_num() {
		return product_num;
	}
	public void setProduct_num(Integer product_num) {
		this.product_num = product_num;
	}
	public String getDrade_name() {
		return drade_name;
	}
	public void setDrade_name(String drade_name) {
		this.drade_name = drade_name;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public List<T> getChildren() {
		return children;
	}
	public void setChildren(List<T> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "ViewProductGradeType [product_id=" + product_id + ", product_name=" + product_name + ", product_desc="
				+ product_desc + ", product_type=" + product_type + ", product_grade=" + product_grade
				+ ", product_price=" + product_price + ", product_num=" + product_num + ", drade_name=" + drade_name
				+ ", type_name=" + type_name + ", children=" + children + "]";
	}
	
	
	
	
}
