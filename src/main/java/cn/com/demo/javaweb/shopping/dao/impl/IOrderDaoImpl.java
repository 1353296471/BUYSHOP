package cn.com.demo.javaweb.shopping.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.demo.javaweb.shopping.dao.IOrderDao;
import cn.com.demo.javaweb.shopping.db.DaoUtils;
import cn.com.demo.javaweb.shopping.entity.OrderList;

@Repository
public class IOrderDaoImpl implements IOrderDao {

	public static void main(String[] args) {
		// 测试datetime类型数据的存取，原表名order与数据库关键字order by重名 故改为orderList

//		OrderList order = new OrderList();
//		order.setProPkid(2);
//		order.setReceivePkid(2);
//		order.setOrderConditionPkid(2);
//		order.setOrderTime(new Timestamp(System.currentTimeMillis()));
//		System.out.println(order.getOrderTime());
//		IOrderDao orderDao = new IOrderDaoImpl();
//		orderDao.add(order);
//		System.out.println(orderDao.getOrder(1, 1).getOrderTime());
	}

	@Override
	public boolean add(OrderList order) {
		String sql = "insert into orderList (proPkid,receivePkid,orderConditionPkid,orderTime,proNum) values (?,?,?,?) ";
		return DaoUtils.insertOrUpdate(sql, order.getProPkid(), order.getReceivePkid(), order.getOrderConditionPkid(),
				order.getOrderTime(), order.getProNum());
	}

	@Override
	public boolean remove(OrderList order) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean update(OrderList order) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public List<OrderList> getOrders(int receivePkid) {
		String sql = "select * from orderList where receivePkid = ?";
		return DaoUtils.getListBySql(OrderList.class, sql, receivePkid);
	}

	@Override
	public OrderList getOrder(int receivePkid, int proPkid) {
		String sql = "select * from orderList where receivePkid = ? and proPkid = ?";
		return DaoUtils.getListBySql(OrderList.class, sql, receivePkid, proPkid).get(0);
	}

}
