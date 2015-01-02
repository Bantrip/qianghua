/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.banyou.backend.repository.mybatis;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class DestDaoTest extends SpringTransactionalTestCase {

	@Autowired
	private DestMyBatisDao dao;
	
	


	@Test
	public void findProductById() throws Exception {
		String keyword="山";
		
		//test find
		assertThat(dao.findDestByKeyword(keyword,10,new Long[0]).size()).isEqualTo(2);
		//test size
		assertThat(dao.findDestByKeyword(keyword,1,new Long[0]).size()).isEqualTo(1);
		//test filterId
		assertThat(dao.findDestByKeyword(keyword,10,new Long[]{1L}).size()).isEqualTo(1);
		//test empty keyword
		assertThat(dao.findDestByKeyword("",10,new Long[]{}).size()).isEqualTo(2);
	}
}
