package com.tjekuaitong.entity;
/**
 * 快递种类
 * @author CCD
 *
 */
public class Express {

	private Integer id ;
	private String spec;//快递名称
	private String price;//实际快递金额
	private Integer is_hidden;//是否显示
	
	
	public Integer getIs_hidden() {
		return is_hidden;
	}
	public void setIs_hidden(Integer is_hidden) {
		this.is_hidden = is_hidden;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Express [id=" + id + ", spec=" + spec + ", price=" + price + ", is_hidden=" + is_hidden + "]";
	}
	
}
