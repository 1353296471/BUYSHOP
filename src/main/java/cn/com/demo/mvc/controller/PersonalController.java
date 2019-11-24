package cn.com.demo.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.demo.javaweb.shopping.entity.User;
import cn.com.demo.javaweb.shopping.entity.toshow.ShowOrderList;
import cn.com.demo.javaweb.shopping.service.IPersonalService;

@Controller
public class PersonalController {

	@Autowired
	private IPersonalService personalService;

	@RequestMapping("/showOrderList")
	public ModelAndView showOrderList(HttpSession session) {
		ModelAndView model = new ModelAndView();
		model.setViewName("orderList");
		User user = (User) session.getAttribute("user");
		List<ShowOrderList> items = personalService.getShowOrderLists(user.getId());
		model.addObject("items", items);
		return model;
	}

	@RequestMapping("/toCharge")
	public ModelAndView toCharge(HttpSession session) {
		ModelAndView model = new ModelAndView();
		model.setViewName("chargeMoney");
		return model;
	}

	@RequestMapping("/chargeMoney")
	public ModelAndView chargeMoney(HttpSession session, double money) {
		ModelAndView model = new ModelAndView();
		model.setViewName("msg");
		String msg = "充值失败！";
		User user = (User) session.getAttribute("user");
		if (personalService.chargeMoney(user.getId(), money)) {
			msg = "充值成功！";
		}
		model.addObject("msg", msg);
		return model;
	}

}
