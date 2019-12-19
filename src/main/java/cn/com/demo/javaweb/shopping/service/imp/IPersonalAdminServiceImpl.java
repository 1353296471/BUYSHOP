package cn.com.demo.javaweb.shopping.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.demo.javaweb.shopping.dao.IImgDao;
import cn.com.demo.javaweb.shopping.dao.IOrderDao;
import cn.com.demo.javaweb.shopping.dao.IProDao;
import cn.com.demo.javaweb.shopping.dao.IReceiveDao;
import cn.com.demo.javaweb.shopping.dao.IShopCarDao;
import cn.com.demo.javaweb.shopping.dao.IShowOrderListDao;
import cn.com.demo.javaweb.shopping.dao.IUserDao;
import cn.com.demo.javaweb.shopping.dao.IWarehouseDao;
import cn.com.demo.javaweb.shopping.entity.toshow.ShowOrderList;
import cn.com.demo.javaweb.shopping.service.IPersonalAdminService;

@Service
public class IPersonalAdminServiceImpl implements IPersonalAdminService {

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

	@Autowired
	private IImgDao imgDao;

	@Autowired
	private IShowOrderListDao showOrderListDao;

	@Override
	public List<ShowOrderList> getShowOrderLists(int userId) {
		List<ShowOrderList> items = new ArrayList<ShowOrderList>();

		items = showOrderListDao.getShowOrderLists(userId);
		return items;
	}

	@Override
	public List<ShowOrderList> getShowOrderListsByPage(int userId, int pageNum, int pageSize) {
		int index = (pageNum - 1) * pageSize;
		List<ShowOrderList> itemsPage = showOrderListDao.getShowOrderListsByPage(userId, index, pageSize);
		return itemsPage;
	}

	@Override
	public int getMaxPage(int pageSize) {
		int maxPage = (showOrderListDao.getAllShowOrderLists().size() + pageSize - 1) / pageSize;
		return maxPage;
	}

	@Override
	public List<ShowOrderList> getAllShowOrderListsByPage(int pageNum, int pageSize) {
		int index = (pageNum - 1) * pageSize;
		List<ShowOrderList> itemsPage = showOrderListDao.getAllShowOrderListsByPage(index, pageSize);
		return itemsPage;
	}

	@Override
	public boolean toSendOrder(int orderPkid) {
		return orderDao.sendOrder(orderPkid);
	}
}
