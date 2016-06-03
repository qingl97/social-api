package com.amundi.social.repo.dao.impl;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.amundi.social.common.model.Application;
import com.amundi.social.repo.DaoTestHelper;
import com.amundi.social.repo.dao.IApplicationDao;

public class ApplicationDaoImplTest {
	
	private IApplicationDao dao = new ApplicationDaoImpl();
	
	@BeforeClass
	public static void setUp() throws IOException {
		DaoTestHelper.populateTestDatabase();
	}
	
	@Test
	public void should_return_an_application_when_provided_appId() {
		// given 
		String appId = "APP-1";
		String userId = "qing.liang-ext@amundi.com";
		// when
		Application app = dao.get(appId);
		// should equal
		assertEquals(userId, app.getCreatorId());
	}

	@Test
	public void should_insert_an_application_success_when_provided_appId_creatorId() {
		// given
		String appId = "APP-5";
		String userId = "qing.liang-ext@amundi.com";
		// when
		dao.add(appId, userId, null);
	}
	
	@Test(expected = RuntimeException.class)
	public void should_insert_an_application_fail_when_creatorId_not_provided() {
		// given
		String appId = "APP-5";
		// when
		dao.add(appId, null, null);
	}
	
	@Test(expected = RuntimeException.class)
	public void should_insert_an_application_fail_when_appId_not_provided() {
		// given
		String userId = "qing.liang-ext@amundi.com";
		// when
		dao.add(null, userId, null);
	}

	@Test
	public void should_delete_success_when_provided_appId() {
		// given
		String appId = "APP-5";
		// when
		dao.delete(appId);
	}
}
