package com.xchen.service;

import java.util.List;

import com.xchen.po.ViewInfo;


public interface ViewInfoService {
	
	
	/**
	 * @param info
	 * @return
	 */
	public boolean add(ViewInfo info);
	
	
	/**
	 * @param info
	 * @return
	 */
	public List<ViewInfo> getList(ViewInfo info);
}
