package com.tjekuaitong.entity;

public class ProductType {

	private Integer id;
	private String type_name;//类别名称
	private String add_time;//添加时间
	private String is_hidden;//是否显示
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public String getAdd_time() {
		return add_time;
	}
	public void setAdd_time(String add_time) {
		this.add_time = add_time;
	}
	public String getIs_hidden() {
		return is_hidden;
	}
	public void setIs_hidden(String is_hidden) {
		this.is_hidden = is_hidden;
	}
	@Override
	public String toString() {
		return "ProductType [id=" + id + ", type_name=" + type_name + ", add_time=" + add_time + ", is_hidden="
				+ is_hidden + "]";
	}
	
}
