package com.tuzhi.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @program: MybatisStudy
 * @description: 博客实体类
 * @author: 兔子
 * @create: 2021-11-19 16:55
 **/

@Data
public class Blog {
    private String id;
    private String title;
    private String author;
    private Date createTime;
    private int views;
}
