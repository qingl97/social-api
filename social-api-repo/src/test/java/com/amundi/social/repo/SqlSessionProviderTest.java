package com.amundi.social.repo;

import static org.junit.Assert.assertNotNull;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class SqlSessionProviderTest {

	@Test
	public void should_return_a_valid_session_when_openSession_invoked() {
		SqlSession session = SqlSessionProvider.openSession();
		assertNotNull(session);
		session.close();
	}

}
