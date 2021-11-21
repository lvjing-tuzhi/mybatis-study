package com.tuzhi.service.role;

import com.tuzhi.dao.RoleMapper;
import com.tuzhi.pojo.Role;
import com.tuzhi.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @program: MybatisStudy
 * @description: 角色业务实现层
 * @author: 兔子
 * @create: 2021-11-20 22:45
 **/

public class RoleServiceImpl implements RoleService{
    @Override
    public List<Role> getRoleList(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        List<Role> roleList = null;
        try {
            roleList = mapper.getRoleList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        sqlSession.close();
        return roleList;
    }
}
