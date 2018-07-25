package com.tjekuaitong.entity;

public class Picture {

	private Integer id;
	private String picture_id;//商品关联
	private String url;//图片路径
	private String add_time;//添加时间
	private String is_hidden;//0显示1不显示
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPicture_id() {
		return picture_id;
	}
	public void setPicture_id(String picture_id) {
		this.picture_id = picture_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
		return "Picture [id=" + id + ", picture_id=" + picture_id + ", url=" + url + ", add_time=" + add_time
				+ ", is_hidden=" + is_hidden + "]";
	}
	
	
}
