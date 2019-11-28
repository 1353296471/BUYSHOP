package cn.com.demo.javaweb.shopping.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.demo.javaweb.shopping.dao.IProDao;
import cn.com.demo.javaweb.shopping.dao.IShopCarDao;
import cn.com.demo.javaweb.shopping.dao.IUserDao;
import cn.com.demo.javaweb.shopping.dao.IWarehouseDao;
import cn.com.demo.javaweb.shopping.entity.ShopCar;
import cn.com.demo.javaweb.shopping.entity.toshow.ShowShopCar;

@Service
public class ICheckoutServiceImpl implements cn.com.demo.javaweb.shopping.service.ICheckoutService {
	@Autowired
	private IProDao proDao;
	@Autowired
	private IShopCarDao shopCarDao;

	@Autowired
	private IUserDao userDao;

	@Autowired
	private IWarehouseDao warehouseDao;

	@Override
	public double getPrice(String[] warehouseIds, List<ShowShopCar> itemList) {
		double price = 0;
		for (String id : warehouseIds) {

			int warehouseId = Integer.parseInt(id);
			int proId = warehouseDao.getWarehouse(warehouseId).getProId();
			for (ShowShopCar sc : itemList) {
				if (sc.getWarehouseId() == warehouseId) {
					price = price + proDao.getProduct(proId).getPrice() * sc.getNum();
				}
			}
		}
		return price;
	}

	/**
	 * 获取用户选中的购物项列表
	 */
	@Override
	public List<ShopCar> getShopCars(String[] warehouseIds, List<ShowShopCar> itemList, int userId) {
		List<ShopCar> shopCars = new ArrayList<ShopCar>();
		for (String id : warehouseIds) {
			int warehouseId = Integer.parseInt(id);
			for (ShowShopCar sc : itemList) {
				if (sc.getWarehouseId() == warehouseId) {
					shopCars.add(shopCarDao.getShopCar(userId, warehouseId));
				}
			}
		}
		return shopCars;
	}

	@Override
	public double getMoney(int userId) {
		return userDao.getUser(userId).getMoney();
	}

}
