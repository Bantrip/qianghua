/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.banyou.backend.repository;

import com.banyou.backend.entity.ProductDesc;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ProductDescDao extends PagingAndSortingRepository<ProductDesc, Long> {
	@Modifying
	@Query("delete ProductDesc pd where pd.product.id=:id")
	public int deleteByProductId(@Param("id")Long id);
}
