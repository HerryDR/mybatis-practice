package com.jsf.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @Description
 * @FileName MybatisCompleteCodeTest
 * @Author JSF
 * @date 2024-08-17
 **/
public class MybatisCompleteCodeTest {
    public static void main(String[] args) {
        SqlSession sqlSession=null;
        try {
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
            sqlSession=sqlSessionFactory.openSession();
            int count=sqlSession.insert("insertCar");
            System.out.println("更新了几条记录：" + count);
            sqlSession.commit();

        } catch (IOException e) {
            if(sqlSession!=null){
                sqlSession.rollback();
            }
            e.printStackTrace();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }
}
