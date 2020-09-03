package com.xq17.snack.utils;

import java.util.Map;

/**
 * 
    * @ClassName: ParameterUtil  
    * @Description: 参数格式化
    * @author xq17  
    * @date 2020年9月3日  
    *
 */
public class ParameterUtil {
	
	/**
	 * 
	    * @Title: changeFindByPageParam  
	    * @Description: 处理分页查询中参数
	    * @param @param map
	    * @param @return    参数  
	    * @return Map<String,Object>    返回类型  
	    * @throws
	 */
	public static Map<String, Object> changeFindByPageParam(Map<String, Object> map){
		int page = Integer.parseInt(String.valueOf(map.get("page")));
		int rows =  Integer.parseInt(String.valueOf(map.get("rows")));
		map.put("page", (page-1)*rows);
		map.put("rows", rows);
		return map;
	}

}
