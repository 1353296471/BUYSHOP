package cn.com.demo.javaweb.shopping.service;

import java.util.List;

import cn.com.demo.javaweb.shopping.entity.toshow.ShowOrderList;

public interface IPersonalService {
	public List<ShowOrderList> getShowOrderLists(int userId);

	public boolean chargeMoney(int userId, double money);
}
