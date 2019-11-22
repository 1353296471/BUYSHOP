package cn.com.demo.javaweb.shopping.dao;

import java.util.List;

import cn.com.demo.javaweb.shopping.entity.OrderList;

public interface IOrderDao {
	public boolean add(OrderList order);

	public boolean remove(OrderList order);

	public boolean update(OrderList order);

	public List<OrderList> getOrders(int receivePkid);

	public OrderList getOrder(int receivePkid, int proId);

}