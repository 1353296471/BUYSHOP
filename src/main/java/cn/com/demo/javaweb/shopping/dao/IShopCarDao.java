package cn.com.demo.javaweb.shopping.dao;

import java.util.List;

import cn.com.demo.javaweb.shopping.entity.ShopCar;

public interface IShopCarDao {
	public List<ShopCar> getShopCar(int userId);

	public ShopCar getShopCar(int userId, int proId);

	public boolean addShopCar(ShopCar shopcar);

	public boolean removeShopCar(ShopCar shopcar);

	public boolean deleteShopCar(ShopCar shopcar);

}
