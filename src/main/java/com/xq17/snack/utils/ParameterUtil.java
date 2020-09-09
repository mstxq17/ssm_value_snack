package com.xq17.snack.utils;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
	public static Map<String, Object> changeFindByPageParam(Map<String, Object> map, HttpServletRequest request){
		int page = Integer.parseInt(String.valueOf(map.get("page")));
		int rows =  Integer.parseInt(String.valueOf(map.get("rows")));
		
		// 判断设备
		String userAgent = request.getHeader("User-Agent");
		if(userAgent.contains("Android") || userAgent.contains("iPhone") || userAgent.contains("iPad")) {
			rows = (int)Math.ceil(rows/3.0)*3;
		}
		
		map.put("page", (page-1)*rows);
		map.put("rows", rows);
		return map;
	}

}
