package com.tuzhi;

import com.tuzhi.dao.UserMapper;
import com.tuzhi.pojo.User;
import com.tuzhi.service.user.UserServiceImpl;
import com.tuzhi.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: MybatisStudy
 * @description: 用户类测试类
 * @author: 兔子
 * @create: 2021-11-20 22:52
 **/

public class UserTest{
    @Test
    public void getLoginUser() {
        UserServiceImpl userService = new UserServiceImpl();
        User admin = userService.getLoginUser("admin");
        System.out.println(admin);
    }

    @Test
    public void add() {
        UserServiceImpl userService = new UserServiceImpl();
        User user = new User();
        user.setUserCode("lv");
        user.setUserName("lv");
        user.setUserPassword("123456789");
        user.setGender(1);
        user.setBirthday(new Date());
        user.setPhone("11111111111");
        user.setAddress("a");
        user.setUserRole(2);
        user.setCreatedBy(1);
        user.setCreationDate(new Date());
        int add = userService.add(user);
        System.out.println(add);
    }

    @Test
    public void getUserList() throws Exception{
        UserServiceImpl userService = new UserServiceImpl();
        HashMap hashMap = new HashMap();
//        hashMap.put("userName","lv");
        hashMap.put("currentPageNo",0);
        hashMap.put("pageSize",2);
        List<User> userList = userService.getUserList(hashMap);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void getUserCount() throws Exception {
        UserServiceImpl userService = new UserServiceImpl();
        HashMap hashMap = new HashMap();
        hashMap.put("userName","admin");
        hashMap.put("userRole",1);
        int userCount = userService.getUserCount(hashMap);
        System.out.println(userCount);
    }


    @Test
    public void deleteUserById() throws Exception {
        UserServiceImpl userService = new UserServiceImpl();
        int i = userService.deleteUserById(30);
        System.out.println(i);
    }

    @Test
    public void getUserById() throws Exception {
        UserServiceImpl userService = new UserServiceImpl();
        User userById = userService.getUserById(1);
        System.out.println(userById);
    }

    @Test
    public void modify() throws Exception {
        UserServiceImpl userService = new UserServiceImpl();
        HashMap hashMap = new HashMap();
        hashMap.put("id",1);
        hashMap.put("userPassword",123);
        int modify = userService.modify(hashMap);
        System.out.println(modify);
    }

    @Test
    public void updatePwd() throws Exception {
        UserServiceImpl userService = new UserServiceImpl();
        User user = new User();
        user.setId(1);
        user.setUserPassword("123456");
        int i = userService.updatePwd(user);
        System.out.println(i);
    }
}
