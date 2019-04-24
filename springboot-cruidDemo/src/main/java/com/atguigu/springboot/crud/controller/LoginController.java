package com.atguigu.springboot.crud.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@PostMapping("/login")
	public String login(@RequestParam String username,@RequestParam String password,
			Map<String, String> map,HttpSession session) {
		if( !StringUtils.isEmpty(username) && "123456".equals(password)) {
			session.setAttribute("loginUser", username);
			return "redirect:main.html";
		}
		map.put("msg", "用户名或密码错误");
		return "index.html";
	}

}
