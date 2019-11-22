package cn.com.demo.javaweb.shopping.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.demo.javaweb.shopping.dao.IProDao;
import cn.com.demo.javaweb.shopping.dao.IShopCarDao;
import cn.com.demo.javaweb.shopping.entity.ShopCar;
import cn.com.demo.javaweb.shopping.entity.toshow.ShowShopCar;

@Service
public class ICheckoutService implements cn.com.demo.javaweb.shopping.service.ICheckoutService {
	@Autowired
	private IProDao proDao;
	@Autowired
	private IShopCarDao shopCarDao;

	@Override
	public double getPrice(String[] proIds, List<ShowShopCar> itemList) {
		double price = 0;
		for (String id : proIds) {
			int proId = Integer.parseInt(id);
			for (ShowShopCar sc : itemList) {
				if (sc.getShowProduct().getPro().getId() == proId) {
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
	public List<ShopCar> getShopCars(String[] proIds, List<ShowShopCar> itemList, int userId) {
		List<ShopCar> shopCars = new ArrayList<ShopCar>();
		for (String id : proIds) {
			int proId = Integer.parseInt(id);
			for (ShowShopCar sc : itemList) {
				if (sc.getShowProduct().getPro().getId() == proId) {
					shopCars.add(shopCarDao.getShopCar(userId, proId));
				}
			}
		}
		return shopCars;
	}

}
