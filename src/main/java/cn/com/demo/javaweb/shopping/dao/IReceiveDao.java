package cn.com.demo.javaweb.shopping.dao;

import cn.com.demo.javaweb.shopping.entity.Receive;

public interface IReceiveDao {
	public Receive getReceives(int userId);

	public Receive getReceive(int userId, int proId);

	public boolean add(Receive receive);

	public boolean remove(Receive receive);
}
