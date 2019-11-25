package cn.com.demo.javaweb.shopping.dao;

import java.sql.Connection;
import java.sql.SQLException;

import cn.com.demo.javaweb.shopping.entity.User;

public interface IUserDao {
	public boolean isRight(String email, String password);

	public boolean addUser(User user);

	public boolean chargeMoney(int userId, double money);

	public boolean isCheck(String email);

	public boolean payMoney(User user, double price);

	public User getUser(String email, String password);

	public User getUser(int userId);

	public boolean payMoney(Connection conn, User user, double price) throws SQLException;
}
