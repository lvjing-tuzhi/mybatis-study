package com.tuzhi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: MybatisStudy
 * @description: 学生实体类
 * @author: 兔子
 * @create: 2021-11-19 09:02
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String name;
    private Teacher teacher;
}
