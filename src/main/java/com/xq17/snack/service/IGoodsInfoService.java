package com.xq17.snack.service;

import java.util.List;
import java.util.Map;

import com.xq17.snack.bean.GoodsInfo;
/**
 * 
    * @ClassName: IGoodsInfoService  
    * @Description: 商品信息业务层模型  
    * @author xq17  
    * @date 2020年9月3日  
    *
 */
public interface IGoodsInfoService {
	
	/**
	 * 
	    * @Title: findByFirst  
	    * @Description: 第一次查询  
	    * @param @param map
	    * @param @return    参数  
	    * @return Map<String,Object>    返回类型  
	    * @throws
	 */
	public Map<String, Object> findByFirst(Map<String, Object> map);
	
	/**
	 * 
	    * @Title: findByPage  
	    * @Description: 分页查询
	    * @param @param map
	    * @param @return    参数  
	    * @return List<GoodsInfo>    返回类型  
	    * @throws
	 */
	public List<GoodsInfo> findByPage(Map<String, Object> map);
	
}
