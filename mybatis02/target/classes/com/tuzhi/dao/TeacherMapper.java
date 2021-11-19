package com.tuzhi.dao;

import com.tuzhi.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @program: MybatisStudy
 * @description: 老师Dao层接口
 * @author: 兔子
 * @create: 2021-11-19 09:08
 **/

public interface TeacherMapper {

    //根据id得到老师列表
//    @Select("select * from teacher where id = #{id}")
    Teacher getTeacherListById(@Param("id") int id);

    //多对一查询
//    第一种查询
    Teacher getTeacherListById1(@Param("id") int id);
//    第二种查询
    Teacher getTeacherListById2(@Param("id") int id);
}
