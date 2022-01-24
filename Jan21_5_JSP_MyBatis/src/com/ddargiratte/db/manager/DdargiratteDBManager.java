package com.ddargiratte.db.manager;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DdargiratteDBManager {
	public static SqlSession connect(String cfgFile) throws Exception {
		InputStream is = Resources.getResourceAsStream(cfgFile);
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
		return ssf.openSession();
	}
}
