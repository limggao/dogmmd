package com.tjekuaitong.entity;

public class Picture {

	private Integer id;
	private Integer product_id;//商品关联
	private String url;//图片路径
	private String add_time;//添加时间
	private String is_hidden;//0显示1不显示
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
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
		return "Picture [id=" + id + ", product_id=" + product_id + ", url=" + url + ", add_time=" + add_time
				+ ", is_hidden=" + is_hidden + "]";
	}
	
	
}
