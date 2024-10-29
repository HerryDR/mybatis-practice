package com.jsf.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description
 * @FileName MyBatisIntroductionTest
 * @Author JSF
 * @date 2024-08-15
 **/
public class MyBatisIntroductionTest {
    public static void main(String[] args) throws Exception {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream is= Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession=sqlSessionFactory.openSession();

        int count=sqlSession.insert("insertCar");
        System.out.println("插入几条数据："+count);
        sqlSession.commit();
        sqlSession.close();

    }
}
