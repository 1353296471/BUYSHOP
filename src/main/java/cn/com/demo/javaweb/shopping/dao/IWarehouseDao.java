package cn.com.demo.javaweb.shopping.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface IWarehouseDao {
	public boolean remove(int proId, int num);

	public boolean add(int proId, int num);

	public boolean remove(Connection conn, int proId, int num) throws SQLException;
}
