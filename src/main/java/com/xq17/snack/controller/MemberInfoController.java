package com.xq17.snack.controller;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xq17.snack.bean.MemberInfo;
import com.xq17.snack.service.IMembersInfoService;
import com.xq17.snack.utils.SendEmailUtil;
import com.xq17.snack.utils.StringUtil;
import com.xq17.snack.vo.ResultVo;

/**
 * 
    * @ClassName: MemberInfoController  
    * @Description: 成员控制类
    * @author xq17  
    * @date 2020年9月7日  
    *
 */
@RestController
@RequestMapping("/member")
public class MemberInfoController {
	
	@Autowired
	private SendEmailUtil sendEmailUtil;
	
	@Autowired
	private IMembersInfoService membersInfoSerice; 
	
	
	/**
	 * 
	    * @Title: sendCode  
	    * @Description: 发送验证码 
	    * @param @param receiveEmail
	    * @param @param name
	    * @param @param session
	    * @param @return    参数  
	    * @return ResultVo    返回类型  
	    * @throws
	 */
	@PostMapping("/code")
	public ResultVo sendCode(String receiveEmail, String name, HttpSession session) {
		if(StringUtil.checkStringNull(receiveEmail, name)) {
			return new ResultVo(501, "您输入的信息不完整", null);
		}
		
		// 1.生成验证码
		String code = "";
		Random rd = new Random();
		while(code.length() < 6) {
			code += rd.nextInt(10);
		}
		
		// 2.发送邮件
		if(sendEmailUtil.sendHtmlMail(receiveEmail, name, code)){
			session.setAttribute("vCode", code);
			// 3.如果邮件发送成功,则将验证码存到Session中并启动一个计时器,3分钟后清空
			//创建一个定时任务
			session.setAttribute("email", receiveEmail);
			TimerTask task = new TimerTask() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					session.removeAttribute("vCode");
				}
			};
			//启用一个定时器,去执行定时任务;
			Timer timer = new Timer();
			timer.schedule(task, 180000); //3分钟之后执行
			
			return new ResultVo(200, "成功", null);
		}
		
		// 4.给客户端一个相应
		return new ResultVo(500, "邮件发送失败", null);
		
	}
	
	/**
	 * 
	    * @Title: reg  
	    * @Description: 会员注册  
	    * @param @param session
	    * @param @param mf
	    * @param @return    参数  
	    * @return ResultVo    返回类型  
	    * @throws
	 */
	@PostMapping("/reg")
	public ResultVo reg(HttpSession session, MemberInfo mf){
		//1.获取验证码
		String email = String.valueOf(session.getAttribute("email"));
		mf.setEmail(email);
		Object obj = session.getAttribute("vCode");
		if(obj == null) {
			return new ResultVo(501, "验证码过期", null);
		}
		
		//2.比较验证码
		String code = String.valueOf(obj);
		if(!code.equals(code)) {
			return new ResultVo(502, "验证码错误", null);
		}
		
		//3.实现注册
		int result = membersInfoSerice.reg(mf);
		if(result == -1) {
			return new ResultVo(503, "您输入的信息不完整", null);
		} else if(result > 0 ) {
			
			return new ResultVo(200, "成功", null);
		}else {
			return new ResultVo(504, "失败", null);
		}
	}
	
	
	/**
	 * 
	    * @Title: login  
	    * @Description: 会员登陆
	    * @param @param session
	    * @param @param mf
	    * @param @return    参数  
	    * @return ResultVo    返回类型  
	    * @throws
	 */
	@PostMapping("/login")
	public ResultVo login(HttpSession session, MemberInfo mf) {
		MemberInfo memberinfo = membersInfoSerice.login(mf);
		if(memberinfo != null) {
			// 将当前登录信息存储到session中
			session.setAttribute("currentLoginMember", memberinfo);
			return new ResultVo(200, "成功", null);
		}
		return new ResultVo(500, "账号或密码错误", null);
		
	}
	
	@GetMapping("/check")
	public ResultVo checkLogin(HttpSession session, MemberInfo mf) {
		// 获取session中的登录信息
		Object obj = session.getAttribute("currentLoginMember");
		if(obj == null) {
			return new ResultVo(500, "没有登录", null);
		}
		return new ResultVo(200, "已经登录", obj);
		
		
	}
}
