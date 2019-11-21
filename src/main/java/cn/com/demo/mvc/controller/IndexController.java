package cn.com.demo.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.demo.javaweb.shopping.entity.User;
import cn.com.demo.javaweb.shopping.entity.toshow.ShowShopCar;
import cn.com.demo.javaweb.shopping.service.IIndexService;

@Controller
public class IndexController {
	@Autowired
	private IIndexService indexService;

	@RequestMapping("/showProduct")
	public ModelAndView showProduct() {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		model.addObject("showProducts", indexService.getShowProduct());
		return model;
	}

	@RequestMapping("/showShopCar")
	public ModelAndView showShopCar(HttpSession session) {
		ModelAndView model = new ModelAndView();
		model.setViewName("shopCarItemList");
		User user = (User) session.getAttribute("user");
		List<ShowShopCar> itemList = indexService.getShopCar(user.getId());
		model.addObject("itemList", itemList);
		model.addObject("itemSize", itemList.size());
		return model;
	}

	@ResponseBody
	@RequestMapping("/addShopCarItem/{proId}")
	public String addShopCarItem(@PathVariable("proId") Integer proId, HttpSession session) throws Exception {
		String msg = null;
		User user = (User) session.getAttribute("user");
		if (indexService.addShopCarItem(user.getId(), proId, 1)) {
			msg = "操作成功！";
		} else {
			msg = "操作失败！";
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping("/removeShopCarItem/{proId}")
	public String removeShopCarItem(@PathVariable("proId") Integer proId, HttpSession session) throws Exception {
		String msg = null;
		User user = (User) session.getAttribute("user");
		if (indexService.removeShopCarItem(user.getId(), proId, 1)) {
			msg = "操作成功！";
		} else {
			msg = "操作失败！";
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping("/deleteShopCarItem/{proId}")
	public String deleteShopCarItem(@PathVariable("proId") Integer proId, HttpSession session) throws Exception {
		String msg = null;
		User user = (User) session.getAttribute("user");
		if (indexService.deleteShopCarItem(user.getId(), proId)) {
			msg = "操作成功！";
		} else {
			msg = "操作失败！";
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping("/isLogin")
	public String isLogin(HttpSession session) throws IOException {
		User user = (User) session.getAttribute("user");
		String msg = null;
		if (user != null) {
//			response.getWriter().print("isLogin");
			msg = "isLogin";
		} else {
//			response.getWriter().print("noLogin");
			msg = "noLogin";
		}
		return msg;
	}

	@RequestMapping("/getUser")
	@ResponseBody
	public User getUser(HttpSession session, HttpServletResponse response) throws IOException {
		User user = (User) session.getAttribute("user");
		return user;
	}
}
