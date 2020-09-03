package com.xq17.snack.utils;

/**
 * 
    * @ClassName: StringUtil  
    * @Description: 字符串工具类
    * @author xq17  
    * @date 2020年9月3日  
    *
 */
public class StringUtil {
	
	/**
	 * 
	    * @Title: checkStringNull  
	    * @Description: 检查字符串是否为空  
	    * @param @param strs
	    * @param @return    参数  
	    * @return boolean    返回类型  
	    * @throws
	 */
	public static boolean checkStringNull(String ... strs) {
		if(strs == null || strs.length <= 0)
		{
			return true;
		}
		for(String str:strs) {
			if(str == null || "".equals(str)){
				return true;
			}
		}
		return false;
	}
}
