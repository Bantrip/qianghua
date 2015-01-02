/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.banyou.backend.repository.mybatis;


import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import com.banyou.backend.entity.Product;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class ProductDaoTest extends SpringTransactionalTestCase {

	@Autowired
	private ProductMyBatisDao dao;
	
	


	@Test
	public void findProductById() throws Exception {
		List<Product> result=
		dao.findProductListByDestsByTags(new Long[]{1L,2L},new Long[0],new PageRequest(0, 15));
		assertThat(result.size()).isEqualTo(3);
		assertThat(dao.findProductListByDestsByTags(new Long[]{1L,2L},new Long[0],new PageRequest(1, 15)).size()).isEqualTo(0);
	}
}
