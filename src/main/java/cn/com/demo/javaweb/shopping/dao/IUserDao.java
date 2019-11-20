package cn.com.demo.javaweb.shopping.dao;

import cn.com.demo.javaweb.shopping.entity.User;

public interface IUserDao {
	public boolean isRight(String email, String password);

	public boolean addUser(User user);

	public User getUser(String email, String password);
}
