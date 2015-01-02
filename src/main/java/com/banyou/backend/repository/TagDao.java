/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.banyou.backend.repository;


import com.banyou.backend.entity.Tag;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface TagDao extends PagingAndSortingRepository<Tag, Long> {

}
