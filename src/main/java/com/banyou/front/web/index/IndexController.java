/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.banyou.front.web.index;

import java.util.List;

import com.banyou.backend.entity.AdContent;
import com.banyou.front.service.adv.AdService;
import com.banyou.front.service.product.DestService;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping(value = "")
public class IndexController {
	private Logger log = LoggerFactory.getLogger(getClass());

	public static final String DEST_CODE = "_USER_DEST";
	@Autowired
	private DestService destService;
	@Autowired
	private AdService adService;

	@RequestMapping(value = { "/", "index", "" }, method = RequestMethod.GET)
	public String index(HttpSession session, Model model) {
		String lunboCode = "INDEX_LUNBO";
		Long[] ids = (Long[]) session.getAttribute(DEST_CODE);
		
		if (!ArrayUtils.isEmpty(ids)) {
			model.addAttribute("dests", destService.findDests(ids));
		}
		List<AdContent> lunboAD = adService.getAdPositionByCode(lunboCode)
				.getContent();
		int lunboMax = 1;
		if (!lunboAD.isEmpty()) {
			model.addAttribute("lunboAd",
					lunboAD.subList(0, Math.min(lunboAD.size(), lunboMax)));
		}

		destService.findDests(ids);
		return "index/index";
	}

}
