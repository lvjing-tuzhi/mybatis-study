package com.tuzhi.service.provider;

import com.tuzhi.pojo.Provider;
import com.tuzhi.pojo.Role;

import java.util.List;
import java.util.Map;

/**
 * @program: MybatisStudy
 * @description: 供应商业务层
 * @author: 兔子
 * @create: 2021-11-20 22:41
 **/

public interface ProviderService {
    /**
     * 增加供应商
     */
    public int add(Provider provider);

    /**
     * 通过供应商名称、编码获取供应商列表-模糊查询-providerList
     *
     */
    public List<Provider> getProviderList(Map map);

    /**
     * 通过proId删除Provider
     */
    public int deleteProviderById(int delId);

    /**
     * 通过proId获取Provider
     */
    public Provider getProviderById(int id);

    /**
     * 修改用户信息
     */
    public int modify(Provider provider);
}
