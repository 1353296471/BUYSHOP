package cn.com.demo.javaweb.shopping.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.com.demo.javaweb.shopping.dao.IOrderDao;
import cn.com.demo.javaweb.shopping.dao.IProDao;
import cn.com.demo.javaweb.shopping.dao.IReceiveDao;
import cn.com.demo.javaweb.shopping.dao.IShopCarDao;
import cn.com.demo.javaweb.shopping.dao.IUserDao;
import cn.com.demo.javaweb.shopping.db.DaoUtils;
import cn.com.demo.javaweb.shopping.entity.ShopCar;

@Repository
public class IShopCarDaoImpl implements IShopCarDao {
	@Autowired
	private IUserDao userDao;

	@Autowired
	private IProDao proDao;

	@Autowired
	private IReceiveDao receiveDao;

	@Autowired
	private IOrderDao orderDao;

	@Override
	public List<ShopCar> getShopCar(int userId) {
		String sql = "select * from shopCar where userId = ?";
		return DaoUtils.getListBySql(ShopCar.class, sql, userId);
	}

	@Override
	public boolean addShopCar(ShopCar shopcar) {
		String sql = "select * from shopCar where userId = ? and warehouseId = ?";
		if (DaoUtils.executeQuery(sql, shopcar.getUserId(), shopcar.getWarehouseId())) {
			sql = "update shopCar set num = num + ? where userId = ? and warehouseId = ?";
			return DaoUtils.insertOrUpdate(sql, shopcar.getNum(), shopcar.getUserId(), shopcar.getWarehouseId());
		} else {
			sql = "insert into shopCar (userId , warehouseId , num) values (?,?,?)";
			return DaoUtils.insertOrUpdate(sql, shopcar.getUserId(), shopcar.getWarehouseId(), shopcar.getNum());
		}
	}

	@Override
	public boolean removeShopCar(ShopCar shopcar) {
		String sql = "select * from shopCar where userId = ? and warehouseId = ?";
		ShopCar sc = DaoUtils.getListBySql(ShopCar.class, sql, shopcar.getUserId(), shopcar.getWarehouseId()).get(0);

		if (sc.getNum() <= 1) {
			return deleteShopCar(shopcar);
		} else {
			sql = "update shopCar set num = num - ? where userId = ? and warehouseId = ?";
			return DaoUtils.insertOrUpdate(sql, shopcar.getNum(), shopcar.getUserId(), shopcar.getWarehouseId());
		}
	}

	@Override
	public boolean deleteShopCar(ShopCar shopcar) {
		String sql = "delete from shopCar where userId = ? and warehouseId = ?";
		return DaoUtils.insertOrUpdate(sql, shopcar.getUserId(), shopcar.getWarehouseId());
	}

	@Override
	public ShopCar getShopCar(int userId, int warehouseId) {
		String sql = "select * from shopCar where userId = ? and warehouseId = ?";
		return DaoUtils.getListBySql(ShopCar.class, sql, userId, warehouseId).get(0);
	}

	@Override
	public boolean deleteShopCar(Connection conn, ShopCar shopcar) throws SQLException {
		String sql = "delete from shopCar where userId = ? and warehouseId = ?";
		return DaoUtils.insertOrUpdate(conn, sql, shopcar.getUserId(), shopcar.getWarehouseId());
	}

}
