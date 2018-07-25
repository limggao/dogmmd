package com.tjekuaitong.entity;

public class Product {
	private Integer id;
	private String product_name;//商品名称
	private String product_desc;//商品说明
	private String product_type;//商品种类
	private String product_grade;//商品分类
	private String product_price;//商品单价金额
	private String product_num;//商品数量
	private String is_hidden;//是否显示
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	public String getProduct_grade() {
		return product_grade;
	}
	public void setProduct_grade(String product_grade) {
		this.product_grade = product_grade;
	}
	public String getProduct_price() {
		return product_price;
	}
	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}
	public String getProduct_num() {
		return product_num;
	}
	public void setProduct_num(String product_num) {
		this.product_num = product_num;
	}
	public String getIs_hidden() {
		return is_hidden;
	}
	public void setIs_hidden(String is_hidden) {
		this.is_hidden = is_hidden;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", product_name=" + product_name + ", product_desc=" + product_desc
				+ ", product_type=" + product_type + ", product_grade=" + product_grade + ", product_price="
				+ product_price + ", product_num=" + product_num + ", is_hidden=" + is_hidden + "]";
	}
	
	
}