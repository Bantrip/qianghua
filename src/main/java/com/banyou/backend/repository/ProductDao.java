/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.banyou.backend.repository;

import com.banyou.backend.entity.Product;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ProductDao extends PagingAndSortingRepository<Product, Long>,JpaSpecificationExecutor<Product> {
	@Modifying(clearAutomatically = true)
	@Query("update Product p set p.status=:status  where p.id=:id and p.status=:prestatus")
	int updateStatus(@Param("id") Long id,@Param("status") int status,@Param("prestatus") int prestatus);
	
}
