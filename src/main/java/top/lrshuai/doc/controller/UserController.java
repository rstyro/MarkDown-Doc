package top.lrshuai.doc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import top.lrshuai.doc.controller.base.BaseController;
import top.lrshuai.doc.service.UserService;
import top.lrshuai.doc.util.ParameterMap;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	@ResponseBody
	public Object login(){
		ParameterMap pm = this.getParameterMap();
		return userService.login(pm,getSession());
	}
}
