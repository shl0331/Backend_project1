package com.koreait.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {

	private static SqlSessionFactory factory;

	// 클래스 초기화 블럭(클래스가 처음 로딩될 때 딱 한번만 수행)
	static {
		// resource : 공장을 짓기위한 설계도 + 공장에 대한 여러 정보가 적힌 문서
		String resource = "./com/koreait/mybatis/config.xml";
		// reader : 공장을 짓기 위한 설계도를 읽고 해석할 설계공학자
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			// [ 건설사 ] [공학자]
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
		}
	}

	public static SqlSessionFactory getFactory() {
		return factory;
	}
}
