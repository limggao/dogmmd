package com.tjekuaitong.entity;

public class Order {

	private Integer id;//
	private String orderid;//订单号
	private Integer product_id;//商品ID
	private String product_name;//商品名称
	private String product_desc;//商品描述
	private String product_grade;//商品属性
	private String product_type;//商品类别
	private Integer product_price;//商品金额
	private Integer actual_price;//实际成交价格
	private Integer sepc_id;//快递id
	private Integer sepc_price;//快递金额
	private String openid;//用户openid
	private String nickName;//姓名
	private String userid;//用户userid
	private String add_time;//下单时间
	private String pay_status;//支付状态 0 成功 200  初始化 1支付失败
	private String order_status;//订单状态 0 下单成功 200 下单初始化 1下单失败
	private String sepc_status;//快递状态 0 已收件  200 配送中  1 拒接收件
	private String pay_time;//支付时间
	private String sepc_time;//到货时间
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
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
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
	public String getProduct_grade() {
		return product_grade;
	}
	public void setProduct_grade(String product_grade) {
		this.product_grade = product_grade;
	}
	public String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	public Integer getProduct_price() {
		return product_price;
	}
	public void setProduct_price(Integer product_price) {
		this.product_price = product_price;
	}
	public Integer getActual_price() {
		return actual_price;
	}
	public void setActual_price(Integer actual_price) {
		this.actual_price = actual_price;
	}
	public Integer getSepc_id() {
		return sepc_id;
	}
	public void setSepc_id(Integer sepc_id) {
		this.sepc_id = sepc_id;
	}
	public Integer getSepc_price() {
		return sepc_price;
	}
	public void setSepc_price(Integer sepc_price) {
		this.sepc_price = sepc_price;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getAdd_time() {
		return add_time;
	}
	public void setAdd_time(String add_time) {
		this.add_time = add_time;
	}
	public String getPay_status() {
		return pay_status;
	}
	public void setPay_status(String pay_status) {
		this.pay_status = pay_status;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public String getSepc_status() {
		return sepc_status;
	}
	public void setSepc_status(String sepc_status) {
		this.sepc_status = sepc_status;
	}
	public String getPay_time() {
		return pay_time;
	}
	public void setPay_time(String pay_time) {
		this.pay_time = pay_time;
	}
	public String getSepc_time() {
		return sepc_time;
	}
	public void setSepc_time(String sepc_time) {
		this.sepc_time = sepc_time;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderid=" + orderid + ", product_id=" + product_id + ", product_name="
				+ product_name + ", product_desc=" + product_desc + ", product_grade=" + product_grade
				+ ", product_type=" + product_type + ", product_price=" + product_price + ", actual_price="
				+ actual_price + ", sepc_id=" + sepc_id + ", sepc_price=" + sepc_price + ", openid=" + openid
				+ ", nickName=" + nickName + ", userid=" + userid + ", add_time=" + add_time + ", pay_status="
				+ pay_status + ", order_status=" + order_status + ", sepc_status=" + sepc_status + ", pay_time="
				+ pay_time + ", sepc_time=" + sepc_time + ", is_hidden=" + is_hidden + "]";
	}
	
	
}
