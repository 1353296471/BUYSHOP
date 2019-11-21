package cn.com.demo.javaweb.shopping.dao;

import java.util.List;

import cn.com.demo.javaweb.shopping.entity.Receive;
import cn.com.demo.javaweb.shopping.entity.ShopCar;

public interface IShopCarDao {
	public List<ShopCar> getShopCar(int userId);

	public boolean addShopCar(ShopCar shopcar);

	public boolean removeShopCar(ShopCar shopcar);

	public boolean deleteShopCar(ShopCar shopcar);

	public boolean payShopCar(ShopCar shopcar, Receive receive);
}
