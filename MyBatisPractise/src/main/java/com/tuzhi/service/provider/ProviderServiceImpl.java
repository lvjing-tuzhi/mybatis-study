package com.tuzhi.service.provider;

import com.tuzhi.dao.ProviderMapper;
import com.tuzhi.dao.RoleMapper;
import com.tuzhi.pojo.Provider;
import com.tuzhi.pojo.Role;
import com.tuzhi.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

/**
 * @program: MybatisStudy
 * @description: 供应商业务实现层
 * @author: 兔子
 * @create: 2021-11-20 22:43
 **/

public class ProviderServiceImpl implements ProviderService{

    @Override
    public int add(Provider provider) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ProviderMapper mapper = sqlSession.getMapper(ProviderMapper.class);
        int add = 0;
        try {
            add = mapper.add(provider);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sqlSession.close();
        return add;
    }

    @Override
    public List<Provider> getProviderList(Map map) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ProviderMapper mapper = sqlSession.getMapper(ProviderMapper.class);
        List<Provider> providerList = null;
        try {
            providerList = mapper.getProviderList(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sqlSession.close();
        return providerList;
    }

    @Override
    public int deleteProviderById(int delId) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ProviderMapper mapper = sqlSession.getMapper(ProviderMapper.class);
        int i = 0;
        try {
            i = mapper.deleteProviderById(delId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sqlSession.close();
        return i;
    }

    @Override
    public Provider getProviderById(int id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ProviderMapper mapper = sqlSession.getMapper(ProviderMapper.class);
        Provider providerById = null;
        try {
            providerById = mapper.getProviderById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sqlSession.close();
        return providerById;
    }

    @Override
    public int modify(Provider provider) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ProviderMapper mapper = sqlSession.getMapper(ProviderMapper.class);
        int modify = 0;
        try {
            modify = mapper.modify(provider);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sqlSession.close();
        return modify;
    }
}
