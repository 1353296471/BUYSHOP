package cn.com.demo.javaweb.shopping.dao;

import java.util.List;

import cn.com.demo.javaweb.shopping.entity.Product;

public interface IProDao {
	public List<Product> getIndexProduct();

	public Product getProduct(int proId);
}
