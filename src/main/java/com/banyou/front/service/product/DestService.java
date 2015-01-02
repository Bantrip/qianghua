/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.banyou.front.service.product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.banyou.backend.entity.Dest;
import com.banyou.backend.repository.DestDao;
import com.banyou.backend.repository.mybatis.DestMyBatisDao;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 目的地管理类
 * 
 * @author calvin
 */
// Spring Service Bean的标识.
@Component
@Transactional
public class DestService {

	private static Logger logger = LoggerFactory.getLogger(DestService.class);

	private DestDao destDao;
	private DestMyBatisDao destMyBatisDao;
	/**
	 * search
	 * @param keyword
	 * @param size
	 * @param ids
	 * @return
	 */
	public List<Dest> findDests(String keyword, int size,Long[] ids) {
		int maxSize=50;
		int defaultSize=10;
		if(keyword==null){
			keyword="";
		}
		if(ids==null){
			ids=new Long[0];
		}
		if(size<0||size>maxSize){
			size=defaultSize;
		}
		return destMyBatisDao.findDestByKeyword(keyword, size,ids);
	}
	
	/**
	 * 
	 * @param pageSize
	 *            分页大小 如果是－1表示不分页
	 * @param pageNo
	 *            第几页
	 * @return
	 */
	public List<Dest> findDests(Long... ids) {
		if(ArrayUtils.isEmpty(ids)){
			return Collections.emptyList();
				}
		List<Dest> result=new ArrayList<>(ids.length);
		for(	Dest dest:
		destDao.findAll(Arrays.asList(ids))){
			result.add(dest);
		}
		return result;
	}
	
	/**
	 * 
	 * @param pageSize
	 *            分页大小 如果是－1表示不分页
	 * @param pageNo
	 *            第几页
	 * @return
	 */
	public Page<Dest> findDests(int pageSize, int pageNo) {
		Pageable page = pageSize>0?new PageRequest(pageNo - 1, pageSize):null;
		return destDao.findAll(page);
	}

	@Autowired
	public void setDestDao(DestDao destDao) {
		this.destDao = destDao;
	}

	@Autowired
	public void setDestMyBatisDao(DestMyBatisDao destMyBatisDao) {
		this.destMyBatisDao = destMyBatisDao;
	}

}
