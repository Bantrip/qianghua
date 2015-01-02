/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.banyou.front.service.product;

import com.banyou.backend.entity.Tag;
import com.banyou.backend.repository.TagDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Tag管理类
 * 
 * @author calvin
 */
// Spring Service Bean的标识.
@Component
@Transactional
public class TagService {

	private static Logger logger = LoggerFactory.getLogger(TagService.class);

	private TagDao tagDao;

	/**
	 * 
	 * @param pageSize
	 *            分页大小 如果是－1表示不分页
	 * @param pageNo
	 *            第几页
	 * @return
	 */
	public Page<Tag> findTags(int pageSize, int pageNo) {
		Pageable page = pageSize>0?new PageRequest(pageNo - 1, pageSize):null;
		return tagDao.findAll(page);
	}
	@Autowired
	public void setTagDao(TagDao tagDao) {
		this.tagDao = tagDao;
	}



}
