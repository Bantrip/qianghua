/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.banyou.backend.repository;

import com.banyou.backend.entity.Dest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class DestDaoTest extends SpringTransactionalTestCase {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private DestDao productImageDao;

	@Test
	public void findProductImageById() throws Exception {
		Dest image = productImageDao.findOne(1L);

		assertThat(image).isNotNull();
		logger.info("find image by id=1,found {}", image);
	}


	
	
}
