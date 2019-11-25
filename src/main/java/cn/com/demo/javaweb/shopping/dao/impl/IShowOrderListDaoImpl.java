package cn.com.demo.javaweb.shopping.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.demo.javaweb.shopping.dao.IShowOrderListDao;
import cn.com.demo.javaweb.shopping.db.DaoUtils;
import cn.com.demo.javaweb.shopping.entity.toshow.ShowOrderList;

@Repository
public class IShowOrderListDaoImpl implements IShowOrderListDao {

	@Override
	public List<ShowOrderList> getShowOrderListsByPage(int userId, int pageNum, int pageSize) {
		int index = (pageNum - 1) * pageSize;
		String sql = "SELECT *  " + "FROM orderlist  "
				+ "INNER JOIN receive ON receive.receivePkid = orderlist.receivePkid "
				+ "INNER JOIN product ON product.id = orderlist.proPkid " + "INNER JOIN img ON img.proId = product.id "
				+ "INNER JOIN `user` ON `user`.id = receive.userPkid "
				+ "INNER JOIN ordercondition ON ordercondition.orderConditionPkid = orderlist.orderConditionPkid "
				+ "WHERE `user`.id = ?  " + "ORDER BY orderlist.orderTime DESC " + "limit ?,? ";
		return DaoUtils.getListBySql(ShowOrderList.class, sql, userId, index, pageSize);
	}

	@Override
	public List<ShowOrderList> getShowOrderLists(int userId) {
		String sql = "SELECT *  " + "FROM orderlist  "
				+ "INNER JOIN receive ON receive.receivePkid = orderlist.receivePkid "
				+ "INNER JOIN product ON product.id = orderlist.proPkid " + "INNER JOIN img ON img.proId = product.id "
				+ "INNER JOIN `user` ON `user`.id = receive.userPkid "
				+ "INNER JOIN ordercondition ON ordercondition.orderConditionPkid = orderlist.orderConditionPkid "
				+ "WHERE `user`.id = ?  " + "ORDER BY orderlist.orderTime DESC ";
		return DaoUtils.getListBySql(ShowOrderList.class, sql, userId);
	}

}
