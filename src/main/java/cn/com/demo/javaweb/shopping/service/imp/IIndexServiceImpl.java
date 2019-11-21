package cn.com.demo.javaweb.shopping.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.demo.javaweb.shopping.dao.IImgDao;
import cn.com.demo.javaweb.shopping.dao.IProDao;
import cn.com.demo.javaweb.shopping.dao.IShopCarDao;
import cn.com.demo.javaweb.shopping.entity.Product;
import cn.com.demo.javaweb.shopping.entity.ShopCar;
import cn.com.demo.javaweb.shopping.entity.toshow.ShowProduct;
import cn.com.demo.javaweb.shopping.entity.toshow.ShowShopCar;
import cn.com.demo.javaweb.shopping.service.IIndexService;

@Service
public class IIndexServiceImpl implements IIndexService {
	@Autowired
	private IProDao proDao;
	@Autowired
	private IImgDao imgDao;
	@Autowired
	private IShopCarDao shopCarDao;

	@Override
	public List<ShowProduct> getShowProduct() {
		// TODO 自动生成的方法存根
		List<ShowProduct> showProducts = new ArrayList<ShowProduct>();
		List<Product> proList = proDao.getIndexProduct();
		for (Product pro : proList) {
			ShowProduct showProduct = new ShowProduct();
			showProduct.setPro(pro);
			showProduct.setMainImg(imgDao.getMainImg(pro.getId()));
			showProducts.add(showProduct);
		}
		return showProducts;
	}

	@Override
	public boolean addShopCarItem(int userId, int proId, int num) {
		ShopCar shopCar = new ShopCar();
		shopCar.setUserId(userId);
		shopCar.setProId(proId);
		shopCar.setNum(num);
		return shopCarDao.addShopCar(shopCar);
	}

	@Override
	public List<ShowShopCar> getShopCar(int userId) {
		List<ShowShopCar> items = new ArrayList<ShowShopCar>();
		List<ShopCar> shopCars = shopCarDao.getShopCar(userId);
		for (ShopCar shopCar : shopCars) {
			ShowShopCar item = new ShowShopCar();

			ShowProduct showProduct = new ShowProduct();
			showProduct.setPro(proDao.getProduct(shopCar.getProId()));
			showProduct.setMainImg(imgDao.getMainImg(shopCar.getProId()));

			item.setShowProduct(showProduct);
			item.setNum(shopCar.getNum());
			items.add(item);
		}
		return items;
	}

	@Override
	public boolean removeShopCarItem(int userId, int proId, int num) {
		if (num <= 0) {
			return deleteShopCarItem(userId, proId);
		} else {
			ShopCar shopCar = new ShopCar();
			shopCar.setUserId(userId);
			shopCar.setProId(proId);
			shopCar.setNum(num);
			return shopCarDao.removeShopCar(shopCar);
		}
	}

	@Override
	public boolean deleteShopCarItem(int userId, int proId) {
		ShopCar shopCar = new ShopCar();
		shopCar.setUserId(userId);
		shopCar.setProId(proId);
		return shopCarDao.deleteShopCar(shopCar);
	}

}
