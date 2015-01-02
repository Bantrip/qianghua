/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.banyou.backend.repository;


import com.banyou.backend.entity.AdPosition;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AdPositionDao extends PagingAndSortingRepository<AdPosition, Long> {
	//@Query("select ap from AdPosition ap join ap.content where ap.code=?")
	AdPosition findByCode(String code);
}
