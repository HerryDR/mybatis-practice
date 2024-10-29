package com.jsf.mybatis;

import com.jsf.mybatis.pojo.Car;
import com.jsf.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @FileName CarMapperTest
 * @Author JSF
 * @date 2024-08-18
 **/
public class CarMapperTest {
    @Test
    public void testInsertCar(){
        // 准备数据
        Map<String, Object> map = new HashMap<>();
        map.put("carNum", "103");
        map.put("brand", "奔驰E300L");
        map.put("guidePrice", 50.3);
        map.put("produceTime", "2020-10-01");
        map.put("carType", "燃油车");
        // 获取SqlSession对象
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // 执行SQL语句（使用map集合给sql语句传递数据）
        int count = sqlSession.insert("insertCar", map);
        sqlSession.commit();
        System.out.println("插入了几条记录：" + count);
    }
    @Test
    public void testInsertCarByPojo(){
        Car car = new Car();

        car.setCarNum("103");
        car.setCarNum("103");
        car.setBrand("奔驰C200");
        car.setGuidePrice(33.23);
        car.setProduceTime("2020-10-11");
        car.setCarType("燃油车");

        // 获取SqlSession对象
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // 执行SQL语句（使用map集合给sql语句传递数据）
        int count = sqlSession.insert("insertCar", car);
        sqlSession.commit();
        System.out.println("插入了几条记录：" + count);
    }
    @Test
    public void testDeleteByCarNum(){
        // 获取SqlSession对象
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // 执行SQL语句
        int count = sqlSession.delete("deleteByCarNum", "102");
        System.out.println("删除了几条记录：" + count);
        sqlSession.commit();
    }
    @Test
    public void testUpdateCarByPOJO(){
        // 准备数据
        Car car = new Car();
        car.setId(1L);
        car.setCarNum("102");
        car.setBrand("比亚迪汉");
        car.setGuidePrice(30.23);
        car.setProduceTime("2018-09-10");
        car.setCarType("电车");
        // 获取SqlSession对象
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // 执行SQL语句
        int count = sqlSession.update("updateCarByPOJO", car);
        sqlSession.commit();
        System.out.println("更新了几条记录：" + count);
    }
    @Test
    public void testSelectCarById(){
        // 获取SqlSession对象
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // 执行SQL语句
        Object car = sqlSession.selectOne("selectCarById", 1);
        System.out.println(car);
    }
    @Test
    public void testSelectCarAll(){
        // 获取SqlSession对象
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // 执行SQL语句
        List<Object> cars = sqlSession.selectList("selectCarAll");
        // 输出结果
        cars.forEach(car -> System.out.println(car));
    }
}
