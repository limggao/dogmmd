package com.tjekuaitong.entity;
/**
 * 物流地址
 * @author CCD
 *
 */
public class Address {

	private Integer id;//
	private String name;//姓名
	private String phone;//电话
	private String address;//地区
	private String detailed_address;//详细地址
	private String add_time;//
	private Integer is_default;//是否默认0默认 1非默认
	private String userid;//用户id
	private String openid;//openid
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDetailed_address() {
		return detailed_address;
	}
	public void setDetailed_address(String detailed_address) {
		this.detailed_address = detailed_address;
	}
	public String getAdd_time() {
		return add_time;
	}
	public void setAdd_time(String add_time) {
		this.add_time = add_time;
	}
	public Integer getIs_default() {
		return is_default;
	}
	public void setIs_default(Integer is_default) {
		this.is_default = is_default;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address
				+ ", detailed_address=" + detailed_address + ", add_time=" + add_time + ", is_default=" + is_default
				+ ", userid=" + userid + ", openid=" + openid + "]";
	}
	
}
