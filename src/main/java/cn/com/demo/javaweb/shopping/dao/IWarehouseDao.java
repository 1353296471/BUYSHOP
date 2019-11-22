package cn.com.demo.javaweb.shopping.dao;

public interface IWarehouseDao {
	public boolean remove(int proId, int num);

	public boolean add(int proId, int num);
}
