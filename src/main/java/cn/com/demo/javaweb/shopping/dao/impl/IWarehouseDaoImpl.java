package cn.com.demo.javaweb.shopping.dao.impl;

import org.springframework.stereotype.Repository;

import cn.com.demo.javaweb.shopping.dao.IWarehouseDao;
import cn.com.demo.javaweb.shopping.db.DaoUtils;

@Repository
public class IWarehouseDaoImpl implements IWarehouseDao {

	@Override
	public boolean remove(int proId, int num) {
		String sql = "update warehouse set num = num - ? where proId = ?";
		return DaoUtils.insertOrUpdate(sql, num, proId);
	}

	@Override
	public boolean add(int proId, int num) {
		// TODO 自动生成的方法存根
		return false;
	}

}
