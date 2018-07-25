package com.tjekuaitong.entity;

public class ProductGrade {
	private Integer id;
	private String drade_id;//分类id
	private String drade_name;//分类名称
	private String add_time;//
	private String is_hidden;//0显示1不显示
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDrade_id() {
		return drade_id;
	}
	public void setDrade_id(String drade_id) {
		this.drade_id = drade_id;
	}
	public String getDrade_name() {
		return drade_name;
	}
	public void setDrade_name(String drade_name) {
		this.drade_name = drade_name;
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
		return "ProductGrade [id=" + id + ", drade_id=" + drade_id + ", drade_name=" + drade_name + ", add_time="
				+ add_time + ", is_hidden=" + is_hidden + "]";
	}
	
}
