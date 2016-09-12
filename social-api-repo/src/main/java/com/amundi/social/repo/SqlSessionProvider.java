package com.amundi.social.repo;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.amundi.social.repo.exceptions.SqlSessionFactoryInitFailedException;

public class SqlSessionProvider {
	
	private static final Logger LOGGER = Logger.getLogger(SqlSessionProvider.class);
	private static final String MYBATIS_CONFIG = "mybatis-config.xml";
	
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			if(sqlSessionFactory == null) {
				synchronized(SqlSessionProvider.class) {
					InputStream inputStream = Resources.getResourceAsStream(MYBATIS_CONFIG);
					sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
					inputStream.close();
				}
				LOGGER.info("SqlSessionFactory initialized");
			}
		} catch (IOException e) {
			LOGGER.error("failed reading mybatis configuration mybatis-config.xml");
			throw new SqlSessionFactoryInitFailedException(e);
		}
	}

	public static SqlSession openSession() {
		return sqlSessionFactory.openSession();
	}
}
