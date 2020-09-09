 package com.xq17.snack.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xq17.snack.bean.MemberInfo;
import com.xq17.snack.mapper.IMemberInfoMapper;
import com.xq17.snack.service.IMembersInfoService;
import com.xq17.snack.utils.StringUtil;

/**
 * 
    * @ClassName: IMemberInfoServceImpl  
    * @Description: 会员信息业务模型层实现
    * @author xq17  
    * @date 2020年9月7日  
    *
 */

@Service
public class IMemberInfoServceImpl implements IMembersInfoService {

	@Autowired
	private IMemberInfoMapper memberInfoMapper; 
	
	@Override
	public MemberInfo login(MemberInfo mf) {
		// TODO Auto-generated method stub
		if(StringUtil.checkStringNull(mf.getNickName(), mf.getPwd())) {
			return null;
		}
		
		return memberInfoMapper.login(mf);
	}
	
	
	@Override
	public int reg(MemberInfo mf) {
		// TODO Auto-generated method stub
		if(StringUtil.checkStringNull(mf.getNickName(), mf.getPwd(), mf.getPwd())) {
			return -1;
		}
		return memberInfoMapper.reg(mf);
	}

}
