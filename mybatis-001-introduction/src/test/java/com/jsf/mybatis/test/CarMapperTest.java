package com.jsf.mybatis.test;

import com.jsf.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;

/**
 * @Description
 * @FileName CarMapperTest
 * @Author JSF
 * @date 2024-08-17
 **/
public class CarMapperTest {
    @Test
    public void testInsertCarByUtil(){
        SqlSession sqlSession= SqlSessionUtil.openSession();
        int count = sqlSession.insert("insertCar");
        System.out.println("插入了几条记录：" + count);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testInsertCar() {
        SqlSession sqlSession=null;
        try {
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
            sqlSession=sqlSessionFactory.openSession();
            int count=sqlSession.insert("insertCar");
            System.out.println("插入了几条记录：" + count);
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
