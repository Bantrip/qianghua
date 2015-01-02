/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.banyou.backend.repository;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.Profiles;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(locations = { "/applicationContext.xml" })
@ActiveProfiles(Profiles.UNIT_TEST)  
public class JpaMappingTest extends SpringTransactionalTestCase {

	private static Logger logger = LoggerFactory.getLogger(JpaMappingTest.class);

	@PersistenceContext
	private EntityManager em;


	

	
	@SuppressWarnings("rawtypes")
	@Test
	public void allClassMapping() throws Exception {
		Metamodel model = em.getEntityManagerFactory().getMetamodel();
		assertThat(model.getEntities()).as("No entity mapping found").isNotEmpty();
		for (EntityType entityType : model.getEntities()) {
			String entityName = entityType.getName();
			logger.info("starting query "+entityName);
			List item=em.createQuery("select o from " + entityName + " o").getResultList();
			logger.info("ok: " + entityName+" : "+item);
		}
	}
}
