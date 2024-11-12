package com.jsf.mybatis.test;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jsf.mybatis.mapper.CarMapper;
import com.jsf.mybatis.pojo.Car;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.util.List;

/**
 * @Description
 * @FileName PageTest
 * @Author JSF
 * @date 2024-11-12
 **/
public class PageTest {
    @Test
    public void testPage()throws Exception{
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        // 页码
        Integer pageNum = 1;
        // 每页显示记录条数
        Integer pageSize = 3;
        // 起始下标
        Integer startIndex = (pageNum - 1) * pageSize;

        List<Car> cars = mapper.selectAllByPage(startIndex, pageSize);
        cars.forEach(car -> System.out.println(car));

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testPageHelper() throws Exception{
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        // 开启分页
        PageHelper.startPage(1, 2);

        // 执行查询语句
        List<Car> cars = mapper.selectAll();

        // 获取分页信息对象
        PageInfo<Car> pageInfo = new PageInfo<>(cars, 5);

        System.out.println(pageInfo);
    }
}
