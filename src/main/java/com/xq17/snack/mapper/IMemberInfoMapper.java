package com.xq17.snack.mapper;

import com.xq17.snack.bean.MemberInfo;

/**
 * 
    * @ClassName: IMemberInfoMapper  
    * @Description: 会员信息管理
    * @author xq17  
    * @date 2020年9月7日  
    *
 */

public interface IMemberInfoMapper {
	
	
	/**
	 * 
	    * @Title: Login  
	    * @Description: 会员登录  
	    * @param @param mf
	    * @param @return    参数  
	    * @return MemberInfo    返回类型  
	    * @throws
	 */
	public MemberInfo login(MemberInfo mf);
	
	/**
	 * 
	    * @Title: reg  
	    * @Description: 会员注册
	    * @param @param mf
	    * @param @return    参数  
	    * @return int    返回类型  
	    * @throws
	 */
	public int reg(MemberInfo mf);
	
}
