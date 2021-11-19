package com.tuzhi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @program: MybatisStudy
 * @description: 用户类
 * @author: 兔子
 * @create: 2021-11-15 22:56
 **/
//使用lombok插件快速setget

//    set、get、toString
@Data
//有参构造
@AllArgsConstructor
//无参构造
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String pwd;

    //    public User() {
//    }
//
//    public User(int id, String name, String pwd) {
//        this.id = id;
//        this.name = name;
//        this.pwd = pwd;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPwd() {
//        return pwd;
//    }
//
//    public void setPwd(String pwd) {
//        this.pwd = pwd;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", pwd='" + pwd + '\'' +
//                '}';
//    }
}
