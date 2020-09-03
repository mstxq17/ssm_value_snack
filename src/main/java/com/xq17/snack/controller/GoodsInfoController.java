package com.xq17.snack.controller;

import java.util.List;
import java.util.Map;

import com.xq17.snack.bean.GoodsInfo;
import com.xq17.snack.service.IGoodsInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xq17.snack.service.IGoodsInfoService;

@RestController
@RequestMapping("/goods")
public class GoodsInfoController{
	
	@Autowired
	private IGoodsInfoService goodsInfoService;
	
	@GetMapping("/findByPage")
	public List<GoodsInfo> findByPage(@RequestParam Map<String, Object> map){
		return goodsInfoService.findByPage(map);
	}

	@GetMapping("/findByFirst")
	public Map<String, Object> findByFirst(@RequestParam Map<String, Object> map){
		return goodsInfoService.findByFirst(map);
	}
	
	
}
