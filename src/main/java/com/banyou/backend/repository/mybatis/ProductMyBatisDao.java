/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.banyou.backend.repository.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.banyou.backend.entity.Product;

@MyBatisRepo
public interface ProductMyBatisDao {

	List<Product> findProductListByDestsByTags(@Param("dests") Long[] dests,@Param("tags") Long[] tags,
			@Param("page") Pageable page);

}
