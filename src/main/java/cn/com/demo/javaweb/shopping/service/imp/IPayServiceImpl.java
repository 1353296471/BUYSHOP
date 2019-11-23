package cn.com.demo.javaweb.shopping.service.imp;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.demo.javaweb.shopping.dao.IOrderDao;
import cn.com.demo.javaweb.shopping.dao.IProDao;
import cn.com.demo.javaweb.shopping.dao.IReceiveDao;
import cn.com.demo.javaweb.shopping.dao.IShopCarDao;
import cn.com.demo.javaweb.shopping.dao.IUserDao;
import cn.com.demo.javaweb.shopping.dao.IWarehouseDao;
import cn.com.demo.javaweb.shopping.entity.OrderList;
import cn.com.demo.javaweb.shopping.entity.Product;
import cn.com.demo.javaweb.shopping.entity.Receive;
import cn.com.demo.javaweb.shopping.entity.ShopCar;
import cn.com.demo.javaweb.shopping.entity.User;
import cn.com.demo.javaweb.shopping.service.IPayService;

@Service
public class IPayServiceImpl implements IPayService {

	@Autowired
	private IUserDao userDao;

	@Autowired
	private IProDao proDao;

	@Autowired
	private IReceiveDao receiveDao;

	@Autowired
	private IOrderDao orderDao;

	@Autowired
	private IShopCarDao shopCarDao;

	@Autowired
	private IWarehouseDao warehouseDao;

	/**
	 * 购买操作，现阶段很不稳定，后续应加上事务，防止数据出错可回滚
	 * 
	 * @param shopcar
	 * @param receive
	 * @return
	 */
	@Override
	public boolean payShopCar(ShopCar shopcar, Receive receive) {
		boolean falg = false;
		// 判断表中是否存在
		ShopCar sc = shopCarDao.getShopCar(shopcar.getUserId(), shopcar.getProId());
		if (sc != null) {
			// 获取对应的商品和用户，判断价格是否足够
			User user = userDao.getUser(shopcar.getUserId());
			Product pro = proDao.getProduct(shopcar.getProId());
			double price = shopcar.getNum() * pro.getPrice();
			if (user.getMoney() >= price) {
				// 执行操作，应该采取事务包围，后续需要改进
				// 1.从购物车中删除对应商品信息
//				shopCarDao.deleteShopCar(shopcar);

				// 2.生成对应的订单信息
				int receivePkid = receiveDao.getReceivePkId(receive);
				OrderList order = new OrderList();
				order.setProPkid(shopcar.getProId());
				order.setProNum(shopcar.getNum());
				order.setReceivePkid(receivePkid);
				order.setOrderConditionPkid(1);
				order.setOrderTime(new Timestamp(System.currentTimeMillis()));
//				orderDao.add(order);

				// 3.从库存中减去对应商品数量
//				warehouseDao.remove(shopcar.getProId(), shopcar.getNum());

				// 4.更新用户的余额信息
//				userDao.payMoney(user, price);
//				DaoUtils.setAutoCommit(false);
				if (shopCarDao.deleteShopCar(shopcar) && orderDao.add(order)
						&& warehouseDao.remove(shopcar.getProId(), shopcar.getNum()) && userDao.payMoney(user, price)) {
					falg = true;
				}
//				DaoUtils.commit();
			}
		}
		return falg;
	}

	@Override
	public boolean payShopCars(List<ShopCar> shopcars, Receive receive) {
		boolean falg = false;
		for (ShopCar sc : shopcars) {
			falg = payShopCar(sc, receive);
			if (!falg) {
				break;
			}
		}
		return falg;
	}

}
