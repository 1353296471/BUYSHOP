package cn.com.demo.javaweb.shopping.entity;

import java.sql.Date;

public class Order {
	private int orderPkid;
	private int proPkid;
	private int receivePkid;
	private int orderConditionPkid;
	private Date orderTime;

	public int getOrderPkid() {
		return orderPkid;
	}

	public void setOrderPkid(int orderPkid) {
		this.orderPkid = orderPkid;
	}

	public int getProPkid() {
		return proPkid;
	}

	public void setProPkid(int proPkid) {
		this.proPkid = proPkid;
	}

	public int getReceivePkid() {
		return receivePkid;
	}

	public void setReceivePkid(int receivePkid) {
		this.receivePkid = receivePkid;
	}

	public int getOrderConditionPkid() {
		return orderConditionPkid;
	}

	public void setOrderConditionPkid(int orderConditionPkid) {
		this.orderConditionPkid = orderConditionPkid;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Order() {
		// TODO 自动生成的构造函数存根
	}

}
