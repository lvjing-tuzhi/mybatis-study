package com.tuzhi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: MybatisStudy
 * @description: 用户类
 * @author: 兔子
 * @create: 2021-11-19 09:04
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String password;
}
