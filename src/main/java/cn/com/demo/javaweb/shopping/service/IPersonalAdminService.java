package cn.com.demo.javaweb.shopping.service;

import java.util.List;

import cn.com.demo.javaweb.shopping.entity.toshow.ShowOrderList;

public interface IPersonalAdminService {
	public List<ShowOrderList> getShowOrderLists(int userId);

	public List<ShowOrderList> getShowOrderListsByPage(int userId, int pageNum, int pageSize);

	public int getMaxPage(int pageSize);

	public List<ShowOrderList> getAllShowOrderListsByPage(int pageNum, int pageSize);

	public boolean toSendOrder(int orderPkid);
}
