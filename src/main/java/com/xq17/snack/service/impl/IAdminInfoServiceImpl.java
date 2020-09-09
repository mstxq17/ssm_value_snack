package com.xq17.snack.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xq17.snack.bean.AdminInfo;
import com.xq17.snack.mapper.IAdminInfoMapper;
import com.xq17.snack.service.IAdminInfoService;
import com.xq17.snack.utils.StringUtil;

/**
 * 
    * @ClassName: IAdminInfoServiceImpl  
    * @Description: 后天管理员登录业务实现层
    * @author xq17  
    * @date 2020年9月8日  
    *
 */

@Service
public class IAdminInfoServiceImpl implements IAdminInfoService {

	@Autowired
	private IAdminInfoMapper adminInfoMapper;
	
	@Override
	public AdminInfo login(AdminInfo af) {
		// TODO Auto-generated method stub
		if(StringUtil.checkStringNull(af.getAname(), af.getPwd())) {
			return null;
		}
		return adminInfoMapper.login(af);
	}

}
