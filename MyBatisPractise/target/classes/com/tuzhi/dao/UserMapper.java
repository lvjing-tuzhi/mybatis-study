package com.tuzhi.dao;

import com.tuzhi.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @program: MybatisStudy
 * @description: 用户dao层接口
 * @author: 兔子
 * @create: 2021-11-20 22:22
 **/

public interface UserMapper {
    /**
     * 增加用户信息
     */
    public int add(User user)throws Exception;

    /**
     * 通过userCode获取User
     */
    public User getLoginUser(String userCode)throws Exception;

    /**
     * 通过条件查询-userList
     * String userName, int userRole, int currentPageNo, int pageSize
     */
    public List<User> getUserList(Map map)throws Exception;

    /**
     * 通过条件查询-用户表记录数
     * String userName, int userRole
     */
    public int getUserCount(Map map)throws Exception;

    /**
     * 通过userId删除user
     */
    public int deleteUserById(Integer delId)throws Exception;

    /**
     * 通过userId获取user
     */
    public User getUserById(int id)throws Exception;

    /**
     * 修改用户信息
     */
    public int modify(Map map)throws Exception;


    /**
     * 修改当前用户密码
     */
    public int updatePwd(User user)throws Exception;


}
