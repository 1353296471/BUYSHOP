package cn.com.demo.javaweb.shopping.dao;

import java.util.List;

import cn.com.demo.javaweb.shopping.entity.toshow.ShowOrderList;

public interface IShowOrderListDao {
	public List<ShowOrderList> getShowOrderListsByPage(int userId, int pageNum, int pageSize);

	public List<ShowOrderList> getShowOrderLists(int userId);
}
