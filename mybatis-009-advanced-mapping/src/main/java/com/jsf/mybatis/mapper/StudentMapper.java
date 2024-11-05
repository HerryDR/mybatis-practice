package com.jsf.mybatis.mapper;

import com.jsf.mybatis.pojo.Student;

import java.util.List;

/**
 * @Description
 * @FileName StudentMapper
 * @Author JSF
 * @date 2024-11-05
 **/
public interface StudentMapper {
    Student selectBySid(Integer sid);
    List<Student> selectByCid(Integer cid);
}
