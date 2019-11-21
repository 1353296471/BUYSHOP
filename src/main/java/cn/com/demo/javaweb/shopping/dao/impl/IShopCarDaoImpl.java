package cn.com.demo.javaweb.shopping.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.com.demo.javaweb.shopping.dao.IProDao;
import cn.com.demo.javaweb.shopping.dao.IShopCarDao;
import cn.com.demo.javaweb.shopping.dao.IUserDao;
import cn.com.demo.javaweb.shopping.db.DaoUtils;
import cn.com.demo.javaweb.shopping.entity.Product;
import cn.com.demo.javaweb.shopping.entity.Receive;
import cn.com.demo.javaweb.shopping.entity.ShopCar;
import cn.com.demo.javaweb.shopping.entity.User;

@Repository
public class IShopCarDaoImpl implements IShopCarDao {
	@Autowired
	private IUserDao userDao;

	@Autowired
	private IProDao proDao;

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
		String sql = "select * from shopCar where userId = ? and proId = ?";
		ShopCar sc = DaoUtils.getListBySql(ShopCar.class, sql, shopcar.getUserId(), shopcar.getProId()).get(0);

		if (sc.getNum() <= 1) {
			return deleteShopCar(shopcar);
		} else {
			sql = "update shopCar set num = num - ? where userId = ? and proId = ?";
			return DaoUtils.insertOrUpdate(sql, shopcar.getNum(), shopcar.getUserId(), shopcar.getProId());
		}
	}

	@Override
	public boolean deleteShopCar(ShopCar shopcar) {
		String sql = "delete from shopCar where userId = ? and proId = ?";
		return DaoUtils.insertOrUpdate(sql, shopcar.getUserId(), shopcar.getProId());
	}

	/**
	 * 购物车购买操作
	 */
	@Override
	public boolean payShopCar(ShopCar shopcar, Receive receive) {
		boolean falg = false;
		// 判断表中是否存在
		String sql = "select * from shopCar where userId = ? and proId = ?";
		if (DaoUtils.executeQuery(sql, shopcar.getUserId(), shopcar.getProId())) {
			// 获取对应的商品和用户，判断价格是否足够
			User user = userDao.getUser(shopcar.getUserId());
			Product pro = proDao.getProduct(shopcar.getProId());
			double price = shopcar.getNum() * pro.getPrice();
			if (user.getMoney() >= price) {
				// 执行操作，1.从购物车中删除对应商品信息
				deleteShopCar(shopcar);
				// 2.更新用户的余额信息
				sql = "update user set money = money - ? where userId = ?";
				falg = DaoUtils.insertOrUpdate(sql, price, user.getId());
				// 3.生成对应的订单信息
			}
		}
		return falg;
	}

}
