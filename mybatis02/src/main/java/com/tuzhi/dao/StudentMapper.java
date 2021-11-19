package com.tuzhi.dao;

import com.tuzhi.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: MybatisStudy
 * @description: 学生类接口
 * @author: 兔子
 * @create: 2021-11-19 09:07
 **/

public interface StudentMapper {
 //   多对一查询
//    第一种查询
    List<Student> getUserList1();
//    第二种查询
    List<Student> getUserList2();
}
