package com.tuzhi.dao;

import com.tuzhi.pojo.Provider;

import java.util.List;
import java.util.Map;

/**
 * @program: MybatisStudy
 * @description: 供应商dao层接口
 * @author: 兔子
 * @create: 2021-11-20 22:21
 **/

public interface ProviderMapper {

    /**
     * 增加供应商
     */
    public int add(Provider provider)throws Exception;


    /**
     * 通过供应商名称、编码获取供应商列表-模糊查询-providerList
     * String proName, String proCode
     */
    public List<Provider> getProviderList(Map map)throws Exception;

    /**
     * 通过proId删除Provider
     */
    public int deleteProviderById(int delId)throws Exception;


    /**
     * 通过proId获取Provider
     */
    public Provider getProviderById(int id)throws Exception;

    /**
     * 修改用户信息
     */
    public int modify(Provider provider)throws Exception;

}
