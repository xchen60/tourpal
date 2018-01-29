package com.xchen.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xchen.mapper.UserInfoMapper;
import com.xchen.po.UserInfo;
import com.xchen.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Resource(name = "userInfoMapper")
	private UserInfoMapper userInfoMapper;
	
	public boolean add(UserInfo user) {
		
		int i = userInfoMapper.insertSelective(user);

		if (i > 0) {
			return true;
		}
		return false;
	}
	
	public void setUserInfoMapper(UserInfoMapper userInfoMapper) {
		this.userInfoMapper = userInfoMapper;
	}

	public List<UserInfo> getUserList(UserInfo record) {

		if (record != null && record.getUserName() != null && !record.getUserName().equals("")) {
			record.setUserName("%" + record.getUserName() + "%");
		}

		return userInfoMapper.getUserList(record);
	}

	public UserInfo getUser(String userNumber) {
		return userInfoMapper.selectByPrimaryKey(userNumber);
	}

	public boolean update(UserInfo user) {
		int isOk = userInfoMapper.updateByPrimaryKeySelective(user);
		if (isOk > 0) {
			return true;
		}
		return false;
	}
	
	public boolean delete(String userNumber) {
		int isOk = userInfoMapper.deleteByPrimaryKey(userNumber);
		if (isOk > 0) {
			return true;
		}
		return false;
	}

}

















