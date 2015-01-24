/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.banyou.front.web.list;

import java.util.Collections;
import java.util.List;

import com.banyou.backend.entity.Dest;
import com.banyou.backend.entity.Product;
import com.banyou.front.service.product.DestService;
import com.banyou.front.service.product.ProductService;
import com.banyou.front.service.product.TagService;
import com.banyou.front.web.JsonView;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;

/**
 * 商品管理的Controller, 使用Restful风格的Urls:
 * 
 * List page : GET /product/ Create page : GET /product/create Create action
 * :POST /product/create Update page : GET /product/update/{id} Update action
 * :POST /product/update Delete action : GET /product/delete/{id}
 * 
 * @author calvin
 */
@Controller
@RequestMapping(value = "/search")
public class SearchController {
	private Logger log = LoggerFactory.getLogger(getClass());

	public static final String DEST_CODE = "_USER_DEST";

	public static final int DEFAULT_KEYWORD_SIZE = 10;

	@Autowired
	private DestService destService;
	@Autowired
	private ProductService productService;
	
	@Autowired
	private TagService tagService;

	@RequestMapping(value = { "dest" }, method = RequestMethod.GET)
	public String search(HttpSession session,
			@RequestParam(value = "keyword", required = false) String keyword,
			Model model) {

		Long[] ids = (Long[]) session.getAttribute(DEST_CODE);
		List<Dest> result = destService.findDests(keyword,
				DEFAULT_KEYWORD_SIZE, ids);
		model.addAttribute(JsonView.CONTENT_NAME, result);

		return "/search/dest";
	}

	@RequestMapping(value = { "toList" }, method = RequestMethod.GET)
	public String toList(HttpSession session,
			@RequestParam(value = "dest", required = false) List<Long> destIds) {
		if (CollectionUtils.isEmpty(destIds)) {
			destIds = Collections.emptyList();
		}
		session.setAttribute(DEST_CODE, destIds.toArray(new Long[0]));
		return "redirect:/search/list";
	}

	@RequestMapping(value = { "list" }, method = RequestMethod.GET)
	public ModelAndView list(
			HttpSession session,
			@RequestParam(value="tagId",required=false) Long[] tagIds,
			@RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize,
			ModelAndView mv) {
		Long[] destIds = (Long[]) session.getAttribute(DEST_CODE);

		if (ArrayUtils.isEmpty(destIds)) {
			destIds = new Long[0];
		}
		
		if (ArrayUtils.isEmpty(tagIds)) {
			tagIds = new Long[0];
		}
		
		
		if (!ArrayUtils.isEmpty(destIds)) {
			mv.addObject("dests", destService.findDests(destIds));
		}
		
		mv.addObject("tags", tagService.findTags(-1, 1));
		
		List<Product> products = productService.searchProducts(destIds,
				tagIds, pageNo, pageSize);
		mv.addObject("result", products);
		mv.setViewName("/search/list");
		return mv;
	}

}
