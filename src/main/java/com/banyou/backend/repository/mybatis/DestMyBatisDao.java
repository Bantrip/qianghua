/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.banyou.backend.repository.mybatis;


import java.util.List;

import com.banyou.backend.entity.Dest;

import org.apache.ibatis.annotations.Param;
@MyBatisRepo
public interface DestMyBatisDao  {
	List<Dest> findDestByKeyword(@Param("keyword")String keyword,@Param("size")int size,@Param("filterIds")Long[] filterIds);
}
