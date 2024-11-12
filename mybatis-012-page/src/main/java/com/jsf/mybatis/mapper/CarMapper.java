package com.jsf.mybatis.mapper;

import com.jsf.mybatis.pojo.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @FileName CarMapper
 * @Author JSF
 * @date 2024-11-12
 **/
public interface CarMapper {
    /**
     * 通过分页的方式获取Car列表
     * @param startIndex 页码
     * @param pageSize 每页显示记录条数
     * @return
     */
    List<Car> selectAllByPage(@Param("startIndex") Integer startIndex, @Param("pageSize") Integer pageSize);

    List<Car> selectAll();
}
