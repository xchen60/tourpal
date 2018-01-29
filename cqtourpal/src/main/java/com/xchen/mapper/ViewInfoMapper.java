package com.xchen.mapper;

import java.util.List;

import com.xchen.po.ViewInfo;

public interface ViewInfoMapper {
    int deleteByPrimaryKey(Integer viewId);

    int insert(ViewInfo record);

    int insertSelective(ViewInfo record);

    ViewInfo selectByPrimaryKey(Integer viewId);

    int updateByPrimaryKeySelective(ViewInfo record);

    int updateByPrimaryKey(ViewInfo record);
    
    List<ViewInfo> getViewInfoList(ViewInfo record);

}