package com.tuzhi;

import com.tuzhi.pojo.Provider;
import com.tuzhi.service.provider.ProviderServiceImpl;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @program: MybatisStudy
 * @description: 供应商测试类
 * @author: 兔子
 * @create: 2021-11-21 20:35
 **/

public class ProviderTest {

    @Test
    public void add() {
        ProviderServiceImpl providerService = new ProviderServiceImpl();
        Provider provider = new Provider();
        provider.setProCode("BJ_GYS001");
        provider.setProName("lv");
        provider.setProDesc("lvlv");
        provider.setProContact("llll");
        provider.setProPhone("11111111111");
        provider.setProAddress("lll");
        provider.setProFax("010-58858787");
        provider.setCreatedBy(1);
        provider.setCreationDate(new Date());
        int add = providerService.add(provider);
        System.out.println(add);
    }

    @Test
    public void getProviderList() {
        ProviderServiceImpl providerService = new ProviderServiceImpl();
        HashMap hashMap = new HashMap();
        hashMap.put("proCode","BJ_GYS001");
        hashMap.put("proName","北");
        List<Provider> providerList = providerService.getProviderList(hashMap);
        for (Provider provider : providerList) {
            System.out.println(provider);
        }
    }

    @Test
    public void deleteProviderById() {
        ProviderServiceImpl providerService = new ProviderServiceImpl();
        int i = providerService.deleteProviderById(16);
        System.out.println(i);
    }

    @Test
    public void getProviderById() {
        ProviderServiceImpl providerService = new ProviderServiceImpl();
        Provider providerById = providerService.getProviderById(1);
        System.out.println(providerById);
    }

    @Test
    public void modifyBy() {
        ProviderServiceImpl providerService = new ProviderServiceImpl();
        Provider provider = new Provider();
        provider.setId(1);
        provider.setModifyDate(new Date());
        int modify = providerService.modify(provider);
        System.out.println(modify);
    }

}
