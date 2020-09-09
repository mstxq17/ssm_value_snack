package com.xq17.snack.service;

import com.xq17.snack.bean.MemberInfo;

/**
 * 
    * @ClassName: IMembersInfoService  
    * @Description: 会员信息管理业务模型  
    * @author xq17  
    * @date 2020年9月7日  
    *
 */
public interface IMembersInfoService {

	/**
	 * 
	    * @Title: login  
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
