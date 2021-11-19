package com.tuzhi.dao;

import com.tuzhi.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @program: MybatisStudy
 * @description: 用户类持久层
 * @author: 兔子
 * @create: 2021-11-15 23:11
 **/

public interface UserMapper {

    //模糊查询
    List<User> getUserListLike(String name);

    //得到用户列表
    List<User> getUserList();

    //按id得到用户
    User getUserById(int id);

    //增加用户
    int addUser(User user);

    //修改用户
    int updateUser(User user);

    //删除用户
    int deleteUser(int id);

    //分页查询
    List<User> getUserLimit(Map<String,Integer> map);

//    使用RowBounds分页
    List<User> getUserRowBounds();

//    使用注解
    @Select("select * from user")
    List<User> getUserListAnnotate();

    @Select("select * from user where id = #{id}")
    User getUserByIdAnnotate(@Param("id") int id);

    @Insert("insert into user(id,name,password) values(#{id},#{name},#{pwd})")
    int addUserAnnotate(User user);

    @Update("update user set name = #{name},password = #{pwd} where id = #{id}")
    int updateUserAnnotate(User user);

    @Delete("delete from user where id = #{id}")

    int deleteUserAnnotate(@Param("id") int id);
}
