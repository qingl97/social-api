package com.amundi.social.repo;

import org.apache.ibatis.session.SqlSession;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SqlSessionProviderTest {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testOpenSession() {
		SqlSession session = SqlSessionProvider.openSession();
		session.close();
	}

}
