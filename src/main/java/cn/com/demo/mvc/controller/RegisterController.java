package cn.com.demo.mvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.demo.javaweb.shopping.dao.IUserDao;
import cn.com.demo.javaweb.shopping.entity.User;

@Controller
public class RegisterController {
	@Autowired // 自动装配类 装配之前需要在配置中包含扫面的包，且需要在类名上加上注解
	private IUserDao userDao;

	@ResponseBody
	@RequestMapping("/register")
	public String register(@RequestBody @Valid User user, BindingResult result) {
		String msg = "notRegister";
		if (result.getErrorCount() > 0) {
			for (FieldError error : result.getFieldErrors()) {
				System.out.println(error.getField() + ":" + error.getDefaultMessage());
				msg = msg + "</br>" + error.getField() + ":" + error.getDefaultMessage();
			}
		} else {
			if (userDao.addUser(user)) {
				msg = "isRegister";
			}
		}
		return msg;
	}

	/**
	 * 检查邮箱是否已经被注册
	 * 
	 * @param user
	 * @param result
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/isCheck/{email}")
	public String isCheck(@PathVariable("email") String email) {
		String msg = "isCheck";
		if (!userDao.isCheck(email)) {
			msg = "notCheck";
		}
		return msg;
	}
}
