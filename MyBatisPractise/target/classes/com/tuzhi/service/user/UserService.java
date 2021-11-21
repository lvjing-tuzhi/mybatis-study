package com.tuzhi.service.user;

import com.tuzhi.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @program: MybatisStudy
 * @description: 用户业务层
 * @author: 兔子
 * @create: 2021-11-20 22:42
 **/

public interface UserService {

    /**
     * 通过userCode获取User
     */
    public User getLoginUser(String userCode);

    /**
     * 增加用户信息
     */
    public int add(User user);

    /**
     * 通过条件查询-userList
     * String userName, int userRole, int currentPageNo, int pageSize
     */
    public List<User> getUserList(Map map);

    /**
     * 通过条件查询-用户表记录数
     * String userName, int userRole
     */
    public int getUserCount(Map map);

    /**
     * 通过userId删除user
     */
    public int deleteUserById(Integer delId);

    /**
     * 通过userId获取user
     */
    public User getUserById(int id);

    /**
     * 修改用户信息
     */
    public int modify(Map map);

    /**
     * 修改当前用户密码
     */
    public int updatePwd(User user);
}
