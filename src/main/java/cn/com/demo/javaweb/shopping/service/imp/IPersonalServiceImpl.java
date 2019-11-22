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
import cn.com.demo.javaweb.shopping.dao.IUserDao;
import cn.com.demo.javaweb.shopping.dao.IWarehouseDao;
import cn.com.demo.javaweb.shopping.entity.Img;
import cn.com.demo.javaweb.shopping.entity.OrderList;
import cn.com.demo.javaweb.shopping.entity.Product;
import cn.com.demo.javaweb.shopping.entity.Receive;
import cn.com.demo.javaweb.shopping.entity.toshow.ShowOrderList;
import cn.com.demo.javaweb.shopping.service.IPersonalService;

@Service
public class IPersonalServiceImpl implements IPersonalService {
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

	@Override
	public List<ShowOrderList> getShowOrderLists(int userId) {
		List<ShowOrderList> items = new ArrayList<ShowOrderList>();

		// 1.根据userId获取所有receive
		List<Receive> res = receiveDao.getReceives(userId);

		for (Receive re : res) {
			// 2.根据receiveId获取所有的order
			for (OrderList o : orderDao.getOrders(re.getReceivePkid())) {
				// 3.根据order中的proPkid获取对应的商品product
				Product pro = proDao.getProduct(o.getProPkid());
				// 4.根据获取product得到对应的图片
				Img mainImg = imgDao.getMainImg(pro.getId());
				// 5.将数据封装在ShowOrderList中，用来显示
				ShowOrderList so = new ShowOrderList();
				so.setMainImg(mainImg);
				so.setPro(pro);
				so.setOrderList(o);
				so.setReceive(re);
				items.add(so);
			}
		}
		return items;
	}

}