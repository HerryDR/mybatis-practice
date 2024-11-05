package com.powernode.mybatis.test;

import com.jsf.mybatis.mapper.ClazzMapper;
import com.jsf.mybatis.mapper.StudentMapper;
import com.jsf.mybatis.pojo.Clazz;
import com.jsf.mybatis.pojo.Student;
import com.jsf.mybatis.utils.SqlSessionUtil;
import org.junit.Test;

/**
 * @Description
 * @FileName StudentMapperTest
 * @Author JSF
 * @date 2024-11-05
 **/
public class StudentMapperTest {
    @Test
    public void testSelectBySid(){
        StudentMapper mapper = SqlSessionUtil.openSession().getMapper(StudentMapper.class);
        Student student = mapper.selectBySid(1);
        System.out.println(student.getSname());
    }

    @Test
    public void testSelectClazzAndStusByCid() {
        ClazzMapper mapper = SqlSessionUtil.openSession().getMapper(ClazzMapper.class);
        Clazz clazz = mapper.selectClazzAndStusByCid(1001);
        System.out.println(clazz);
    }
}
