package com.tuzhi.utils;

import org.junit.Test;

import java.util.UUID;

/**
 * @program: MybatisStudy
 * @description: 生成UUID
 * @author: 兔子
 * @create: 2021-11-19 16:49
 **/

public class IDutils {
    public static String getid() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    @Test
    public void test() {
        System.out.println(IDutils.getid());
    }
}
