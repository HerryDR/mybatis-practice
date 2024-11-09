package com.jsf.mybatis.mapper;

import com.jsf.mybatis.pojo.Car;

/**
 * @Description
 * @FileName CarMapper
 * @Author JSF
 * @date 2024-11-09
 **/
public interface CarMapper {
    /**
     * 根据id获取Car信息。
     * @param id
     * @return
     */
    Car selectById(Long id);
}
