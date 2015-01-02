/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.banyou.backend.repository;

import com.banyou.backend.entity.Product;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class ProductDaoTest extends SpringTransactionalTestCase {

	@Autowired
	private ProductDao productDao;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void findProductById() throws Exception {
		Product product = productDao.findOne(1L);
	
		assertThat(product).isNotNull();	
		}
	
	
	@Test
	public void changeProductStatus() throws Exception {
		Product product = productDao.findOne(3L);
		int size=productDao.updateStatus(3L, product.getStatus()+1,product.getStatus());
		 product = productDao.findOne(3L);
		
		assertThat(product.getStatus()).isEqualTo(2);	
		assertThat(size).isEqualTo(1);	
		}
}
