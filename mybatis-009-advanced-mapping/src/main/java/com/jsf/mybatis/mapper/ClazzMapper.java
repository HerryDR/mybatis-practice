package com.jsf.mybatis.mapper;

import com.jsf.mybatis.pojo.Clazz;

/**
 * @Description
 * @FileName ClazzMapper
 * @Author JSF
 * @date 2024-11-05
 **/
public interface ClazzMapper {
    /**
     * 根据cid获取Clazz信息
     * @param cid
     * @return
     */
    Clazz selectByCid(Integer cid);

    /**
     * 根据班级编号查询班级信息。同时班级中所有的学生信息也要查询。
     * @param cid
     * @return
     */
    Clazz selectClazzAndStusByCid(Integer cid);
}
