package com.tuzhi.service.user;

import com.tuzhi.dao.UserMapper;
import com.tuzhi.pojo.User;
import com.tuzhi.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: MybatisStudy
 * @description: 角色业务实现层
 * @author: 兔子
 * @create: 2021-11-20 22:45
 **/

public class UserServiceImpl implements UserService{


    @Override
    public User getLoginUser(String userCode) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User admin = null;
        try {
            admin = mapper.getLoginUser("admin");
        } catch (Exception e) {
            e.printStackTrace();
        }
        sqlSession.close();
        return admin;
    }

    @Override
    public int add(User user) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int flag = 0;
        try {
            flag = mapper.add(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sqlSession.close();
        return flag;
    }

    @Override
    public List<User> getUserList(Map map){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = null;
        try {
            userList = mapper.getUserList(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sqlSession.close();
        return userList;
    }

    @Override
    public int getUserCount(Map map) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int userCount = 0;
        try {
            userCount = mapper.getUserCount(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userCount;
    }

    @Override
    public int deleteUserById(Integer delId) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = 0;
        try {
            i = mapper.deleteUserById(delId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sqlSession.close();
        return i;
    }

    @Override
    public User getUserById(int id){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = null;
        try {
            userById = mapper.getUserById(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sqlSession.close();
        return userById;
    }

    @Override
    public int modify(Map map) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int modify = 0;
        try {
            modify = mapper.modify(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sqlSession.close();
        return modify;
    }

    @Override
    public int updatePwd(User user) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = 0;
        try {
            i = mapper.updatePwd(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sqlSession.close();
        return i;
    }
}
