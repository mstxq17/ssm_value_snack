package com.xq17.snack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xq17.snack.bean.GoodsType;
import com.xq17.snack.mapper.IGoodsTypeMapper;
import com.xq17.snack.service.IGoodsTypeService;

/*
 * 
    * @ClassName: IGoodsTypeServiceImpl  
    * @Description: 商品类型业务模型层实现类  
    * @author xq17  
    * @date 2020年9月2日  
    *
 */
@Service /* 说明这个是业务层的bean */
public class IGoodsTypeServiceImpl implements IGoodsTypeService {
	
	@Autowired //采用自动注入的方式
	private IGoodsTypeMapper goodsTypeMapper;
	
	@Override
	public List<GoodsType> finds() {
		// TODO Auto-generated method stub
		// 通过数据模型层访问数据库，返回数据
		return goodsTypeMapper.finds();
	}

	@Override
	public List<GoodsType> findAll() {
		// TODO Auto-generated method stub
		return goodsTypeMapper.findAll();
	}

}
