package cn.com.demo.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.com.demo.javaweb.shopping.entity.User;
import cn.com.demo.javaweb.shopping.entity.toshow.ShowShopCar;
import cn.com.demo.javaweb.shopping.service.IIndexService;

@Controller
public class CheckoutController {
	@Autowired
	private IIndexService indexService;

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
	public ModelAndView toPay(HttpSession session, @RequestParam("buyProId") String[] buyProId) {
		ModelAndView model = new ModelAndView();
		model.setViewName("pay");
		User user = (User) session.getAttribute("user");
		model.addObject("price", 250);
		return model;
	}
}
