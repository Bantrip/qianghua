/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.banyou.backend.repository;

import com.banyou.backend.entity.Product;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class ProductDescDaoTest extends SpringTransactionalTestCase {

	@Autowired
	private ProductDao productDao;
	
	
	
	@Autowired
	private ProductDescDao productDescDao;


	@Test
	public void findProductById() throws Exception {
		long id=1;
		
		productDescDao.deleteByProductId(id);
		Product product = productDao.findOne(id);
		
		assertThat(product.getDescs().size()).isEqualTo(0);
	}
}
