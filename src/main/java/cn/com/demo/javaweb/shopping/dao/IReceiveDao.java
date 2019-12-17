package cn.com.demo.javaweb.shopping.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import cn.com.demo.javaweb.shopping.entity.Receive;

public interface IReceiveDao {
	@Select({ "select * from receive where userPkid = #{userId}" })
	public List<Receive> getReceives(int userId);

	public Receive getReceive(int userId, int proId);

	@Insert({
			"insert into receive (userPkid,sheng,shi,qu,userAddress,userPhone) values (#{userPkid},#{sheng},#{shi},#{qu},#{userAddress},#{userPhone})" })
	public boolean add(Receive receive);

	public boolean remove(Receive receive);

	public int getReceivePkId(Receive receive);
}
