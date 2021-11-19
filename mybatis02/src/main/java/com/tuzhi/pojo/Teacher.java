package com.tuzhi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @program: MybatisStudy
 * @description: 老师类
 * @author: 兔子
 * @create: 2021-11-19 09:03
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private int id;
    private String name;
    private List<Student> student;
}
