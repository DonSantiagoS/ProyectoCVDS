package edu.eci.cvds.utils.connection;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlConnection <T> {
	
	
	private static SqlSession session;
	
	private static SqlSessionFactory getSqlSessionFactory() {
		SqlSessionFactory sqlSessionFactory = null;
		if (sqlSessionFactory == null) {
			InputStream inputStream;
			try {
				inputStream = Resources.getResourceAsStream("mybatis-config.xml");
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	        } catch (IOException e) {
	        	throw new RuntimeException(e.getCause());
	        } catch (RuntimeException re) {
	        	re.printStackTrace();
	        }
	    }
		return sqlSessionFactory;
	}
	
	private static SqlSession getSqlSession() {
		SqlSessionFactory sqlSessionFact = getSqlSessionFactory();
		SqlSession sqlSession = null;
		try {
			  sqlSession = sqlSessionFact.openSession();
		} catch (NullPointerException npe) {
			
		}
		return sqlSession;
	}
	
	
	public static <T>T getMapper(Class<T> elem) {
		if (session == null) {
			session = getSqlSession();
		}
		return session.getMapper(elem);
	}
	
	
	public static void commit() {
		if (session == null) {
			session = getSqlSession();
		}
		session.commit();
	}

}
