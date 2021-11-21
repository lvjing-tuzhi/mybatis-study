package com.tuzhi.dao;

import com.tuzhi.pojo.Role;

import java.util.List;

/**
 * @program: MybatisStudy
 * @description: 角色dao层接口
 * @author: 兔子
 * @create: 2021-11-20 22:21
 **/

public interface RoleMapper {
    public List<Role> getRoleList()throws Exception;
}
