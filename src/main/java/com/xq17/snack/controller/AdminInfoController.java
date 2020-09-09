package com.xq17.snack.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xq17.snack.bean.AdminInfo;
import com.xq17.snack.service.IAdminInfoService;
import com.xq17.snack.vo.ResultVo;

@RestController
@RequestMapping("/admin")
public class AdminInfoController {
	
	@Autowired
	private IAdminInfoService adminInfoService;
	
	@PostMapping("login")
	public ResultVo login(HttpSession session,AdminInfo af) {
		AdminInfo adminInfo = adminInfoService.login(af);
		if(adminInfo != null) {
			session.setAttribute("currentLoginAdmin", adminInfo);
			return new ResultVo(200, "登录成功", null);
		}
		return new ResultVo(500, "账号或密码错误", null);		
	}
}
