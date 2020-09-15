package com.xq17.snack.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class CreateCodeController {
	
	@GetMapping("/code")
	public void createCode(HttpSession session, HttpServletResponse response) throws IOException {
		// 1.设置不缓存
		response.setHeader("Pragma", "no-cache");
		response.setHeader("cache-controle", "no-cache");
		response.setDateHeader("Expire", 0);
		
		// 获取验证码
		String code = getRondomCode();
		session.setAttribute("validateCode", code);
		
		// 创建验证码图片
		BufferedImage image = this.getCodeImage(code, 110, 36);
		
		// 返回生成的验证码图片
		ImageIO.write(image, "JPEG", response.getOutputStream());
		
	}
	
	/**
	 * 
	    * @Title: getCodeImage  
	    * @Description: 生产验证码图片 
	    * @param @param code 生产的验证码
	    * @param @param width 图片的宽度
	    * @param @param height 图片的高度
	    * @param @return    参数  
	    * @return BufferedImage    返回类型  
	    * @throws
	 */
	private BufferedImage getCodeImage(String code, int width, int height) {
		// TODO Auto-generated method stub
		
		// 1.申请图片对象缓存空间
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		// 2.获取一个绘制这个图片区域的工具
		Graphics g = image.getGraphics();
		
		// 3.设置绘制的颜色 -> 随机获取
		g.setColor(getRandomColor(225,30));
		
		// 4.绘制这张图片的背景
		g.fillRect(0, 0, width, height);
		
		// 5.生成干扰线
		Random rd = new Random();
		int x1, y1, x2, y2;
		for(int i=0; i<50; i++) {
			x1 = rd.nextInt(width);
			y1 = rd.nextInt(height);
			x2 = rd.nextInt(width);
			y2 = rd.nextInt(height);
			
			// 设置干扰线颜色
			g.setColor(getRandomColor(140, 60));
			g.drawLine(x1, y1, x2, y2);
		}
		
		// 6.绘制验证码
		//   设置验证码的字体
		g.setFont(new Font("Courier New",Font.ITALIC, 24));
		
		// 一个字母一个字母绘制
		char[] codes = code.toCharArray();
		for(int i = 0;  i < code.length(); i++) {
			// 设置验证码字符串的颜色
			g.setColor(getRandomColor(40, 70));
			g.drawString(String.valueOf(codes[i]), 20+20*i, 26);
		}
		
		g.dispose();
		return image;
	}

	/**
	 * 
	    * @Title: getRandomColor  
	    * @Description: 获取随机的RGB值
	    * @param @param start
	    * @param @param bound
	    * @param @return    参数  
	    * @return Color    返回类型  
	    * @throws
	 */
	private Color getRandomColor(int start, int bound) {
		// TODO Auto-generated method stub
		Random rd = new Random();
		int r = start + rd.nextInt(bound);
		int g = start + rd.nextInt(bound);
		int b = start + rd.nextInt(bound);
		return new Color(r, g, b);
	}


	/**
	 * 
	    * @Title: getRondomCode  
	    * @Description: 获取验证码方法
	    * @param @return    参数  
	    * @return String    返回类型  
	    * @throws
	 */
	private String getRondomCode() {
		// TODO Auto-generated method stub
		Random rd = new Random();
		
		StringBuffer code = new StringBuffer();
		int flag = 0;
		for(int i=0;i<4;i++) {
			flag = rd.nextInt(3);
			switch(flag) {
				case 0: code.append(rd.nextInt(10));break;
				case 1: code.append((char)(rd.nextInt(26)+65));break;
 				case 2: code.append((char)(rd.nextInt(26)+97));break;
			}
		}
		//System.out.println(code.toString());
		return code.toString();
		
	}
}
