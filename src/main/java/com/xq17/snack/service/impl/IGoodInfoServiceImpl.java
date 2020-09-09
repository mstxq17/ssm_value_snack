package com.xq17.snack.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xq17.snack.bean.GoodsInfo;
import com.xq17.snack.mapper.IGoodsInfoMapper;
import com.xq17.snack.service.IGoodsInfoService;
import com.xq17.snack.utils.ParameterUtil;

/**
 * 
    * @ClassName: IGoodInfoServiceImpl  
    * @Description: 商品信息业务实现层 
    * @author xq17  
    * @date 2020年9月3日  
    *
 */


@Service
public class IGoodInfoServiceImpl implements IGoodsInfoService {

	@Autowired
	private IGoodsInfoMapper goodsInfoMapper;
	
	@Override
	public Map<String, Object> findByFirst(Map<String, Object> map) {
		
		// TODO Auto-generated method stub
		//map = ParameterUtil.changeFindByPageParam(map);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", goodsInfoMapper.total());
		result.put("rows", goodsInfoMapper.findByPage(map));
		return result;
	}

	
	@Override
	public List<GoodsInfo> findByPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<GoodsInfo> result = goodsInfoMapper.findByPage(map);
		return result;
	}


	@Override
	public Map<String, Object> finds(Map<String, Object> map) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", goodsInfoMapper.totals(map));
		result.put("rows", goodsInfoMapper.finds(map));
		return result;
	}


	@Override
	public int add(GoodsInfo gf) {
		// TODO Auto-generated method stub
		return goodsInfoMapper.add(gf);
	}

}
