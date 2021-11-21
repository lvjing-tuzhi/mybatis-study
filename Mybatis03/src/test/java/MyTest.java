import com.tuzhi.dao.BlogMapper;
import com.tuzhi.pojo.Blog;
import com.tuzhi.utils.IDutils;
import com.tuzhi.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @program: MybatisStudy
 * @description: 测试
 * @author: 兔子
 * @create: 2021-11-19 17:04
 **/

public class MyTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();

        blog.setId(IDutils.getid());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(999);
        mapper.addBlog(blog);

        blog.setId(IDutils.getid());
        blog.setTitle("Java如此简单");
        mapper.addBlog(blog);

        blog.setId(IDutils.getid());
        blog.setTitle("Spring如此简单");
        mapper.addBlog(blog);

        blog.setId(IDutils.getid());
        blog.setTitle("微服务如此简单");
        mapper.addBlog(blog);

        sqlSession.close();
    }

    @Test
    public void getBlogIf() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("title","Java");
//        hashMap.put("author","狂神说");
        List<Blog> blogIf = mapper.getBlogIf(hashMap);
        for (Blog blog : blogIf) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void updateBlog() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap hashMap = new HashMap();
        hashMap.put("views",1);
        hashMap.put("title","java");
        hashMap.put("id","988ec9153a81497c9c55bc331fa3ef60");

        mapper.updateBlog(hashMap);
        sqlSession.close();
    }

    @Test
    public void queryForech() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        HashMap hashMap = new HashMap();
        hashMap.put("ids",arrayList);
        mapper.queryForeach(hashMap);

        sqlSession.close();
    }

//    缓存测试
    @Test
    public void cacheTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blogById = mapper.getBlogById(1);
        System.out.println(blogById);
        sqlSession.close();

        System.out.println("=============");

        SqlSession sqlSession1 = MybatisUtils.getSqlSession();
        BlogMapper mapper1 = sqlSession1.getMapper(BlogMapper.class);
        Blog blogById1 = mapper1.getBlogById(1);
        System.out.println(blogById1);
        sqlSession1.close();

        System.out.println(blogById == blogById1);
    }

}
