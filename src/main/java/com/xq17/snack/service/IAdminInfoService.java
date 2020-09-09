package com.xq17.snack.service;

import com.xq17.snack.bean.AdminInfo;

/**
 * 
    * @ClassName: IAdminInfoService  
    * @Description: 后台管理员登录业务模型层
    * @author xq17  
    * @date 2020年9月8日  
    *
 */
public interface IAdminInfoService {
	
	/**
	 * 
	    * @Title: login  
	    * @Description: 管理员登录  
	    * @param @param af
	    * @param @return    参数  
	    * @return AdminInfo    返回类型  
	    * @throws
	 */
	public AdminInfo login(AdminInfo af);
}
