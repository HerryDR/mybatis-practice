package com.jsf.mybatis.mapper;

import com.jsf.mybatis.pojo.Car;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @FileName CarMapper
 * @Author JSF
 * @date 2024-11-01
 **/
public interface CarMapper {
    /**
     * 根据id主键查询：结果最多只有一条
     * @param id
     * @return
     */
    Car selectById(Long id);

    /**
     * 根据id主键查询：结果最多只有一条，可以放到List集合中吗？
     * @return
     */
    List<Car> selectByIdToList(Long id);

    /**
     * 查询所有的Car
     * @return
     */
    List<Car> selectAll();

    /**
     * 通过id查询一条记录，返回Map集合
     * @param id
     * @return
     */
    Map<String, Object> selectByIdRetMap(Long id);

    /**
     * 查询所有的Car，返回一个List集合。List集合中存储的是Map集合。
     * @return
     */
    List<Map<String,Object>> selectAllRetListMap();

    /**
     * 获取所有的Car，返回一个Map集合。
     * Map集合的key是Car的id。
     * Map集合的value是对应Car。
     * @return
     */
    @MapKey("id")
    Map<Long,Map<String,Object>> selectAllRetMap();

    /**
     * 查询所有Car，使用resultMap进行结果映射
     * @return
     */
    List<Car> selectAllByResultMap();

    /**
     * 查询所有Car，启用驼峰命名自动映射
     * @return
     */
    List<Car> selectAllByMapUnderscoreToCamelCase();

    /**
     * 获取总记录条数
     * @return
     */
    Long selectTotal();
}
