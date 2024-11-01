package com.powernode.mybatis.test;

import com.jsf.mybatis.mapper.CarMapper;
import com.jsf.mybatis.pojo.Car;
import com.jsf.mybatis.utils.SqlSessionUtil;
import org.junit.Test;

import java.util.List;

/**
 * @Description
 * @FileName CarMapperTest
 * @Author JSF
 * @date 2024-11-01
 **/
public class CarMapperTest {
    @Test
    public void testSelectByMultiCondition(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByMultiCondition("", 30.0, "燃油车");
        System.out.println(cars);
    }

    @Test
    public void testSelectByMultiConditionWithWhere(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByMultiConditionWithWhere("", null, "");
        System.out.println(cars);
    }

    @Test
    public void testSelectByMultiConditionWithTrim(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByMultiConditionWithTrim("丰田", 20.0, "");
        System.out.println(cars);
    }

    @Test
    public void testUpdateWithSet(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        Car car = new Car(15L,"1001","丰田霸道2",10.0,"",null);
        int count = mapper.updateWithSet(car);
        System.out.println(count);
        SqlSessionUtil.openSession().commit();
    }

    @Test
    public void testSelectWithChoose(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        //List<Car> cars = mapper.selectWithChoose("丰田霸道", 20.0, "2000-10-10");
        //List<Car> cars = mapper.selectWithChoose("", 20.0, "2000-10-10");
        //List<Car> cars = mapper.selectWithChoose("", null, "2000-10-10");
        List<Car> cars = mapper.selectWithChoose("", null, "");
        System.out.println(cars);
    }

    @Test
    public void testDeleteBatchByForeach(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        int count = mapper.deleteBatchByForeach(new Long[]{9L, 10L, 12L});
        System.out.println("删除了几条记录：" + count);
        SqlSessionUtil.openSession().commit();
    }

    @Test
    public void testDeleteBatchByForeach2(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        int count = mapper.deleteBatchByForeach2(new Long[]{9L, 10L, 15L});
        System.out.println("删除了几条记录：" + count);
        SqlSessionUtil.openSession().commit();
    }
}
