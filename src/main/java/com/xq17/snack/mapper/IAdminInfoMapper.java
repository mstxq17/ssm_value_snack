package com.xq17.snack.mapper;

import com.xq17.snack.bean.AdminInfo;

/**
 * 
    * @ClassName: IAdminsInfoMapper  
    * @Description: 后台管理数据层  
    * @author xq17  
    * @date 2020年9月8日  
    *
 */
public interface IAdminInfoMapper {
	
	/**
	 * 
	    * @Title: login  
	    * @Description: 后台管理员登录  
	    * @param @param af
	    * @param @return    参数  
	    * @return AdminsInfo    返回类型  
	    * @throws
	 */
	public AdminInfo login(AdminInfo af);
	

}
