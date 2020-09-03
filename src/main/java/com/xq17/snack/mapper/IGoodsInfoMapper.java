package com.xq17.snack.mapper;

import java.util.List;
import java.util.Map;

import com.xq17.snack.bean.GoodsInfo;
/**
 * 
 * 
    * @ClassName: IGoodsInfoMapper  
    * @Description: 商品信息管理数据模型层
    * @author xq17  
    * @date 2020年9月3日  
    *
 */
public interface IGoodsInfoMapper {
	/**
	 * 
	    * @Title: total  
	    * @Description: 返回总记录数
	    * @param @return    参数  
	    * @return Integer    返回类型  
	    * @throws
	 */
	public int total();
	
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
