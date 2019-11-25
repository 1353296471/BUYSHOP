package cn.com.demo.javaweb.shopping.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

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

	@Override
	public boolean remove(Connection conn, int proId, int num) throws SQLException {
		String sql = "update warehouse set num = num - ? where proId = ?";
		return DaoUtils.insertOrUpdate(conn, sql, num, proId);
	}

}
