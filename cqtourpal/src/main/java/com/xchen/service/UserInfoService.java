package com.xchen.service;

import java.util.List;

import com.xchen.po.UserInfo;


/**
 * 用户信息逻辑接口
 * @author Thomas
 * 2018-1-23 15:21:02
 */
public interface UserInfoService {
	
	/**
	 * 添加用户信息
	 * @param user
	 * @return
	 */
	public boolean add(UserInfo user);
	
	/**
	 * 查询用户信息
	 * @param record
	 * @return
	 */
	public List<UserInfo> getUserList(UserInfo record);

	/**
	 * @param userNumber
	 * @return
	 */
	public UserInfo getUser(String userNumber);

	/**
	 * @param user
	 * @return
	 */
	public boolean update(UserInfo user);

	/**
	 * @param userNumber
	 * @return
	 */
	public boolean delete(String userNumber);
	

}




