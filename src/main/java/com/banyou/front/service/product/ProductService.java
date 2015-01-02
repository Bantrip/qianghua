/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.banyou.front.service.product;

import java.util.List;
import com.banyou.backend.entity.Product;
import com.banyou.backend.repository.ProductDao;
import com.banyou.backend.repository.mybatis.ProductMyBatisDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 商品管理类
 * 
 * @author calvin
 */
// Spring Service Bean的标识.
@Component
@Transactional
public class ProductService {

	private static Logger logger = LoggerFactory
			.getLogger(ProductService.class);

	private ProductDao productDao;
	
	private ProductMyBatisDao productMyBatisDao;


	
	/**
	 * 获取单个商品信息
	 * 
	 * @param id
	 * @return
	 */
	public Product getProduct(Long id) {

		Product product = productDao.findOne(id);
		if(product.getStatus()!=Product.STATUS_OK)
			return null;
		return product;
	}

	/**
	 * 
	 * @param pageSize
	 *            分页大小
	 * @param pageNo
	 *            第几页
	 * @return
	 */
	public List<Product> searchProducts(Long[] dests,Long[] tags, int pageNo,int pageSize) {

		Pageable page = pageSize > 0 ? new PageRequest(pageNo - 1, pageSize)
				: null;
		
		return productMyBatisDao.findProductListByDestsByTags(dests, tags, page);
		
	}
	
	
	





	@Autowired
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}



	

@Autowired
	public void setProductMyBatisDao(ProductMyBatisDao productMyBatisDao) {
		this.productMyBatisDao = productMyBatisDao;
	}

}
