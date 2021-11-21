package com.tuzhi;

import com.tuzhi.pojo.Role;
import com.tuzhi.service.provider.ProviderServiceImpl;
import com.tuzhi.service.role.RoleServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * @program: MybatisStudy
 * @description: 角色测试类
 * @author: 兔子
 * @create: 2021-11-21 20:03
 **/

public class RoleTest {

    @Test
    public void getRoleList() {
        RoleServiceImpl roleService = new RoleServiceImpl();
        List<Role> roleList = roleService.getRoleList();
        for (Role role : roleList) {
            System.out.println(role);
        }
    }
}
