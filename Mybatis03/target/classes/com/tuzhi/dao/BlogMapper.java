package com.tuzhi.dao;

import com.tuzhi.pojo.Blog;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @program: MybatisStudy
 * @description: 博客的dao层接口
 * @author: 兔子
 * @create: 2021-11-19 16:58
 **/

public interface BlogMapper {
//    插入数据
    int addBlog(Blog blog);

    //查询
    List<Blog> getBlogIf(Map map);

//    更新数据
    int updateBlog(Map map);

//    用Foreach动态查询
    List<Blog> queryForeach(Map map);

//    按id查blog
//    @Select("select * from blog where id = #{id}")
    Blog getBlogById(@Param("id") int id);

}
