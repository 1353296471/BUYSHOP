package cn.com.demo.javaweb.shopping.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.demo.javaweb.shopping.dao.IReceiveDao;
import cn.com.demo.javaweb.shopping.db.DaoUtils;
import cn.com.demo.javaweb.shopping.entity.Receive;

@Repository
public class IReceiveDaoImpl implements IReceiveDao {

	@Override
	public List<Receive> getReceives(int userId) {
		String sql = "select * from receive where userPkid = ?";
		return DaoUtils.getListBySql(Receive.class, sql, userId);
	}

	@Override
	public Receive getReceive(int userId, int proId) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public boolean add(Receive receive) {
		String sql = "insert into receive (userPkid,sheng,shi,qu,userAddress,userPhone) values (?,?,?,?,?,?) ";
		return DaoUtils.insertOrUpdate(sql, receive.getUserPkid(), receive.getSheng(), receive.getShi(),
				receive.getQu(), receive.getUserAddress(), receive.getUserPhone());
	}

	@Override
	public boolean remove(Receive receive) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public int getReceivePkId(Receive receive) {
		int pkId = -1;
		boolean falg = false;
		String sql = "select * from receive where userPkid=? and sheng=? and shi=? and qu=? and userAddress =? and userPhone=?";
		falg = DaoUtils.executeQuery(sql, receive.getUserPkid(), receive.getSheng(), receive.getShi(), receive.getQu(),
				receive.getUserAddress(), receive.getUserPhone());
		Receive rec;
		if (!falg) {
			add(receive);
			rec = DaoUtils.getListBySql(Receive.class, sql, receive.getUserPkid(), receive.getSheng(), receive.getShi(),
					receive.getQu(), receive.getUserAddress(), receive.getUserPhone()).get(0);
		} else {
			rec = DaoUtils.getListBySql(Receive.class, sql, receive.getUserPkid(), receive.getSheng(), receive.getShi(),
					receive.getQu(), receive.getUserAddress(), receive.getUserPhone()).get(0);
		}
		pkId = rec.getReceivePkid();
		return pkId;
	}

}
