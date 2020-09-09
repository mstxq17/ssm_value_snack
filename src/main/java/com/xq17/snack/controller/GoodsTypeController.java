package com.xq17.snack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xq17.snack.bean.GoodsType;
import com.xq17.snack.service.IGoodsTypeService;

@RestController /* 说明这是控制层类,数据为json格式*/
@RequestMapping("/types")
public class GoodsTypeController {
	
	@Autowired
	private IGoodsTypeService goodsTypeService;
	
	@GetMapping("/finds")
	public List<GoodsType> finds(){
		return goodsTypeService.finds();
	}
	
	@GetMapping("/findAll")
	public List<GoodsType> findsAll(){
		return goodsTypeService.findAll();
	}
	
}
