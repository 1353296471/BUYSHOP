package cn.com.demo.mvc.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.demo.javaweb.shopping.dao.IUserDao;
import cn.com.demo.javaweb.shopping.entity.User;

@Validated
@Controller
public class LoginController {
	@Autowired // 自动装配类 装配之前需要在配置中包含扫面的包，且需要在类名上加上注解
	private IUserDao userDao;

	/**
	 * 登录方法的简单测试
	 * 
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/login")
	public boolean login(@RequestBody @Valid User user, BindingResult result, HttpSession session) {
		System.out.println(user);
		boolean flag = false;
		if (result.getErrorCount() > 0) {
			System.out.println("出错了!");
			for (FieldError error : result.getFieldErrors()) {
				System.out.println(error.getField() + ":" + error.getDefaultMessage());
			}
		} else if (!userDao.isRight(user.getEmail(), user.getPassword())) {
			System.out.println(result);
		} else {
			session.setAttribute("user", userDao.getUser(user.getEmail(), user.getPassword()));
			flag = true;
		}
		return flag;
	}
}
