package com.tuzhi.dao;

import com.tuzhi.pojo.Student;
import com.tuzhi.pojo.Teacher;
import com.tuzhi.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @program: MybatisStudy
 * @description: 测试
 * @author: 兔子
 * @create: 2021-11-19 09:15
 **/

public class Test {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacherListById1 = mapper.getTeacherListById2(1);
        System.out.println(teacherListById1);
        sqlSession.close();
    }
}
