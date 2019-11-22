package cn.com.demo.javaweb.shopping.service;

import java.util.List;

import cn.com.demo.javaweb.shopping.entity.ShopCar;
import cn.com.demo.javaweb.shopping.entity.toshow.ShowShopCar;

public interface ICheckoutService {
	public double getPrice(String[] proIds, List<ShowShopCar> itemList);

	public List<ShopCar> getShopCars(String[] proIds, List<ShowShopCar> itemList, int userId);
}
