package cn.com.demo.javaweb.shopping.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import cn.com.demo.javaweb.shopping.entity.OrderList;

public interface IOrderDao {
	@Insert({
			"insert into orderList (warehouseId,receivePkid,orderConditionPkid,orderTime,proNum) values (#{warehouseId},#{receivePkid},#{orderConditionPkid},#{orderTime},#{proNum}) " })
	public boolean add(OrderList order);

	public boolean remove(OrderList order);

	public boolean update(OrderList order);

	@Select({ "select * from orderList where receivePkid = #{receivePkid}" })
	public List<OrderList> getOrders(int receivePkid);

	@Select({ "select * from orderList where receivePkid = #{param1} and warehouseId = #{param2}" })
	public OrderList getOrder(int receivePkid, int warehouseId);

	@Insert({
			"insert into orderList (warehouseId,receivePkid,orderConditionPkid,orderTime,proNum) values (#{warehouseId},#{receivePkid},#{orderConditionPkid},#{orderTime},#{proNum}) " })
	public boolean addByConn(Connection conn, OrderList order) throws SQLException;

}
