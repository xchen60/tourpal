package com.xchen.mapper;

import java.util.List;

import com.xchen.po.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(String userNumber);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(String userNumber);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
    
    public List<UserInfo> getUserList(UserInfo record);
}