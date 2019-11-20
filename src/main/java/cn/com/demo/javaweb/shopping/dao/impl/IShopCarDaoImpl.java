package cn.com.demo.javaweb.shopping.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.demo.javaweb.shopping.dao.IShopCarDao;
import cn.com.demo.javaweb.shopping.db.DaoUtils;
import cn.com.demo.javaweb.shopping.entity.ShopCar;

@Repository
public class IShopCarDaoImpl implements IShopCarDao {

	@Override
	public List<ShopCar> getShopCar(int userId) {
		String sql = "select * from shopCar where userId = ?";
		return DaoUtils.getListBySql(ShopCar.class, sql, userId);
	}

	@Override
	public boolean addShopCar(ShopCar shopcar) {
		String sql = "select * from shopCar where userId = ? and proId = ?";
		if (DaoUtils.executeQuery(sql, shopcar.getUserId(), shopcar.getProId())) {
			sql = "update shopCar set num = num + ? where userId = ? and proId = ?";
			return DaoUtils.insertOrUpdate(sql, shopcar.getNum(), shopcar.getUserId(), shopcar.getProId());
		} else {
			sql = "insert into shopCar (userId , proId , num) values (?,?,?)";
			return DaoUtils.insertOrUpdate(sql, shopcar.getUserId(), shopcar.getProId(), shopcar.getNum());
		}
	}

	@Override
	public boolean removeShopCar(ShopCar shopcar) {
		String sql = "update shopCar set num = num - ? where userId = ? and proId = ?";
		return DaoUtils.insertOrUpdate(sql, shopcar.getNum(), shopcar.getUserId(), shopcar.getProId());
	}

}
