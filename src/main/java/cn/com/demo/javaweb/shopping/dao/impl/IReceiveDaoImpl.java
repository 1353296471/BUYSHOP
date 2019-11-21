package cn.com.demo.javaweb.shopping.dao.impl;

import cn.com.demo.javaweb.shopping.dao.IReceiveDao;
import cn.com.demo.javaweb.shopping.db.DaoUtils;
import cn.com.demo.javaweb.shopping.entity.Receive;

public class IReceiveDaoImpl implements IReceiveDao {

	@Override
	public Receive getReceives(int userId) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Receive getReceive(int userId, int proId) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public boolean add(Receive receive) {
		String sql = "insert into receive (userPkid,sheng,shi,qu,userAddress,userPhone) values (?,?,?,?,?,?) ";
		return DaoUtils.insertOrUpdate(sql, receive.getUserPkid(), receive.getSheng(), receive.getShi(),
				receive.getQu(), receive.getUserAddress(), receive.getUserPhone());
	}

	@Override
	public boolean remove(Receive receive) {
		// TODO 自动生成的方法存根
		return false;
	}

}
