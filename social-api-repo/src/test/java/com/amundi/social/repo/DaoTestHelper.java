package com.amundi.social.repo;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.session.SqlSession;

public class DaoTestHelper {

	public static void populateTestDatabase() throws IOException {
		// populate in-memory database
		try(SqlSession session = SqlSessionProvider.openSession()) {
			Connection conn = session.getConnection();
			Reader reader = Resources.getResourceAsReader("CreateDB.sql");
			
			ScriptRunner runner = new ScriptRunner(conn);
			runner.setLogWriter(null);
			runner.runScript(reader);
			reader.close();
		}
	}

}
