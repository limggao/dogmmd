package com.tjekuaitong.entity;
/**
 * 获取用户所有信息
 * @author Administrator
 *
 */
public class User {

	private String openid;//openid
	private String nickname;//名字
	private String gender;//性别
	private String city;//城市
	private String country;//国家
	private String province;//省份
	private String avatarUrl;//头像url
	private String language;//用户的语言，简体中文为zh_CN
	private String unionid;
	private String watermark;
	private String appid;
	private String timestamp;
	private String phone;
	private String user_grade;//用户等级
	private String category;//等级名称
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	public String getWatermark() {
		return watermark;
	}
	public void setWatermark(String watermark) {
		this.watermark = watermark;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUser_grade() {
		return user_grade;
	}
	public void setUser_grade(String user_grade) {
		this.user_grade = user_grade;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "User [openid=" + openid + ", nickname=" + nickname + ", gender=" + gender + ", city=" + city
				+ ", country=" + country + ", province=" + province + ", avatarUrl=" + avatarUrl + ", language="
				+ language + ", unionid=" + unionid + ", watermark=" + watermark + ", appid=" + appid + ", timestamp="
				+ timestamp + ", phone=" + phone + ", user_grade=" + user_grade + ", category=" + category + "]";
	}
	
	
	
}
