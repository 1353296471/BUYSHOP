package cn.com.demo.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.demo.javaweb.shopping.entity.User;
import cn.com.demo.javaweb.shopping.entity.toshow.ShowShopCar;
import cn.com.demo.javaweb.shopping.service.ICheckoutService;
import cn.com.demo.javaweb.shopping.service.IIndexService;

@Controller
public class CheckoutController {
	@Autowired
	private IIndexService indexService;

	@Autowired
	private ICheckoutService checkoutService;

	@RequestMapping("/updateBuyList")
	public ModelAndView updateBuyList(HttpSession session) {
		ModelAndView model = new ModelAndView();
		model.setViewName("toBuyList");
		User user = (User) session.getAttribute("user");
		List<ShowShopCar> itemList = indexService.getShopCar(user.getId());
		model.addObject("itemList", itemList);
		model.addObject("itemSize", itemList.size());
		return model;
	}

	@RequestMapping("/toPay")
	public ModelAndView toPay(HttpSession session, @RequestParam("warehouseIds") String[] warehouseIds) {
		ModelAndView model = new ModelAndView();

		User user = (User) session.getAttribute("user");
		session.setAttribute("warehouseIds", warehouseIds);
		List<ShowShopCar> itemList = indexService.getShopCar(user.getId());
		double price = checkoutService.getPrice(warehouseIds, itemList);
		if (price > user.getMoney()) {
			model.setViewName("msg");
			model.addObject("type", "price");
			model.addObject("msg", "您的账户余额不足，请先充值！");
		} else {
			model.setViewName("pay");
			model.addObject("price", price);
			model.addObject("userId", user.getId());
		}
		return model;
	}

	@ResponseBody
	@RequestMapping("/getPrice/{warehouseIds}")
	public String getPrice(HttpSession session, @PathVariable("warehouseIds") String[] warehouseIds) {
		User user = (User) session.getAttribute("user");
		session.setAttribute("warehouseIds", warehouseIds);
		List<ShowShopCar> itemList = indexService.getShopCar(user.getId());
		double price = checkoutService.getPrice(warehouseIds, itemList);
		return String.valueOf(price);
	}
}
