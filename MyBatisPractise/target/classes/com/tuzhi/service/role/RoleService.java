package com.tuzhi.service.role;

import com.tuzhi.pojo.Role;

import java.util.List;

/**
 * @program: MybatisStudy
 * @description: 角色业务层
 * @author: 兔子
 * @create: 2021-11-20 22:42
 **/

public interface RoleService {
    public List<Role> getRoleList();
}
