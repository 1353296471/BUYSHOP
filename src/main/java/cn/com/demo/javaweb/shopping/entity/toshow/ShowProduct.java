package cn.com.demo.javaweb.shopping.entity.toshow;

import cn.com.demo.javaweb.shopping.entity.Img;
import cn.com.demo.javaweb.shopping.entity.Product;

public class ShowProduct {
	private Product pro;
	private Img mainImg;

	public Product getPro() {
		return pro;
	}

	public void setPro(Product pro) {
		this.pro = pro;
	}

	public Img getMainImg() {
		return mainImg;
	}

	public void setMainImg(Img mainImg) {
		this.mainImg = mainImg;
	}

	public ShowProduct() {
		// TODO 自动生成的构造函数存根
	}
}
