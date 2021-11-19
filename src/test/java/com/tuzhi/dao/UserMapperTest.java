package com.tuzhi.dao;

import com.tuzhi.pojo.User;
import com.tuzhi.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;



/**
 * @program: MybatisStudy
 * @description:
 * @author: 兔子
 * @create: 2021-11-15 23:19
 **/

public class UserMapperTest {
    static Logger logger = Logger.getLogger(UserMapper.class);

    @Test
    public void test() {
        logger.info("进入TestUserList");
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUserAnnotate(8);
        sqlSession.close();
    }

    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);
        sqlSession.close();
    }

    @Test
    public void addUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addUser(new User(7,"three","123"));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(3,"lisan","123456789"));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(4);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getUserListLike() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> user = mapper.getUserListLike("李");
        for (User user1 : user) {
            System.out.println(user1);
        }
        sqlSession.close();
    }

//    分页查询
    @Test
    public void getUserLimit() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex",0);
        map.put("pageSize",2);
        List<User> userLimit = mapper.getUserLimit(map);
        for (User user : userLimit) {
            System.out.println(user);
        }
        sqlSession.close();
    }

//    使用RowBounds进行分页查询
    @Test
    public void getUserRowBounds() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RowBounds rowBounds = new RowBounds(0, 2);
        List<User> userList = sqlSession.selectList("com.tuzhi.dao.UserMapper.getUserRowBounds",null,rowBounds);
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

//    使用注解的方法
    @Test
    public void getUserListAnnotate() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userListAnnotate = mapper.getUserListAnnotate();
        for (User user : userListAnnotate) {
            System.out.println(user);
        }
        sqlSession.close();
    }

}
