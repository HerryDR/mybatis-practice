package com.jsf.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @Description
 * @FileName SqlSessionUtil
 * @Author JSF
 * @date 2024-08-18
 **/
public class SqlSessionUtil {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static  ThreadLocal<SqlSession> local=new ThreadLocal<>();

    public static SqlSession openSession() {
        SqlSession sqlSession=local.get();
        if (sqlSession == null) {
            sqlSession=sqlSessionFactory.openSession();
            local.set(sqlSession);
        }
        return sqlSession;
    }
    public static void close(SqlSession sqlSession){
        if (sqlSession != null) {
            sqlSession.close();
        }
        local.remove();
    }
}
