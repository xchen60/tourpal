package com.xchen.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xchen.mapper.ViewInfoMapper;
import com.xchen.po.ViewInfo;
import com.xchen.service.ViewInfoService;

@Service
public class ViewInfoServiceImpl implements ViewInfoService {

	@Resource(name = "viewInfoMapper")
	private ViewInfoMapper viewInfoMapper;
	
	
	public boolean add(ViewInfo viewinfo) {
		
		int i = viewInfoMapper.insertSelective(viewinfo);
		if (i > 0) {
			return true;
		}
		return false;
	}


	public ViewInfoMapper getViewInfoMapper() {
		return viewInfoMapper;
	}


	public void setViewInfoMapper(ViewInfoMapper viewInfoMapper) {
		this.viewInfoMapper = viewInfoMapper;
	}


	public List<ViewInfo> getList(ViewInfo info) {

		if (info != null && info.getViewName() != null
				&& !info.getViewName().equals("")) {
			info.setViewName("%" + info.getViewName() + "%");
		}

		return viewInfoMapper.getViewInfoList(info);
	}
	
	

}
