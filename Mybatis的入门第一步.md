# 1.Mybatis的入门

## 1.添加依赖

~~~xml
<dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.18</version>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.4.6</version>
        </dependency>
~~~

~~~xml
<build>
<resources>
    <resource>
        <directory>src/main/resources</directory>
       <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
        <filtering>false</filtering>
    </resource>
    <resource>
        <directory>src/main/java</directory>
        <includes>
            <include>**/*.properties</include>
            <include>**/*.xml</include>
        </includes>
        <filtering>false</filtering>
    </resource>
</resources>
</build>
~~~

## 2.在resouces文件下新建xml文件db.properties

写配置文件

~~~properties
driver=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://localhost:3306/mybatis?serverTimezone=Asia/Shanghai&useSSL=true&useUnicode=true&characterEncoding=utf-8
username=root
password=DRsXT5ZJ6Oi55LPQ
~~~





## 3.在resouces文件下新建xml文件mybatis-config-xml

~~~xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

    <properties resource="db.properties"/>

    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="${driver}"/>
                <property name="url" value="${url}"/>
                <property name="username" value="${username}"/>
                <property name="password" value="${password}"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <mapper resource="com/tuzhi/dao/UserMapper.xml"/>
    </mappers>
</configuration>
~~~

## 3.创建一个MybatisUtils工具类

~~~java
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        String resource = "org/mybatis/example/mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    public SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }
}
~~~

## 4.创建xml文件XxxMapper.xml映射dao层接口

~~~xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!--映射dao层接口-->
<mapper namespace="com.tuzhi.dao.UserDao">
<!--    映射接口里面的方法-->
    <select id="getUserList" resultType="com.tuzhi.pojo.User">
        select * from user
    </select>
</mapper>
~~~

## 5.测试

~~~java
@Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
~~~

# 2.增删改查

## 1.select

~~~xml
<select id="getUserById" resultType="com.tuzhi.pojo.User" parameterType="int">
        select * from user where id = #{id}
    </select>
~~~

## 2.delete

~~~xml
<delete id="deleteUser" parameterType="com.tuzhi.pojo.User">
        delete
        from USER
        where id = #{id};
    </delete>
~~~

## 3.update

~~~xml
<update id="updateUser" parameterType="com.tuzhi.pojo.User">
        update USER
        set name = #{name},pwd = #{pwd}
        where id = #{id};
    </update>
~~~

## 4.insert

~~~xml
<insert id="addUser" parameterType="com.tuzhi.pojo.User">
        insert into USER (id,name ,pwd)
        values (#{id},#{name},#{pwd});
    </insert>
~~~

## 5.模糊查询

~~~xml
<select id="getUserListLike" resultType="com.tuzhi.pojo.User">
        select * from user where name like concat('%',#{name},'%')
    
    </select>
~~~

## 6.分页查询

~~~xml
<!--    分页查询-->
    <select id="getUserLimit" parameterType="map" resultMap="userResultMap">
        select * from user limit #{startIndex},#{pageSize}
    </select>
~~~



# 3.起别名

## 3.1具体的某个文件

~~~xml
<typeAliases>
  <typeAlias alias="Author" type="domain.blog.Author"/>
  <typeAlias alias="Blog" type="domain.blog.Blog"/>
  <typeAlias alias="Comment" type="domain.blog.Comment"/>
  <typeAlias alias="Post" type="domain.blog.Post"/>
  <typeAlias alias="Section" type="domain.blog.Section"/>
  <typeAlias alias="Tag" type="domain.blog.Tag"/>
</typeAliases>
~~~

## 3.2给包名起别名

~~~xml
<typeAliases>
  <package name="domain.blog"/>
</typeAliases>
~~~

注，用别名的时候直接用文件名，全小写

## 3.3用注解起别名

```
@Alias("author")
```

注，直接在类上注解

# 4.解决实体属性名与数据库列名不一致问题

## 1.建一个resultMap标签

~~~xml
<resultMap id="userResultMap" type="User">
    //property实体类里的，column数据库里的
  <id property="id" column="user_id" />
  <result property="username" column="user_name"/>
  <result property="password" column="hashed_password"/>
</resultMap>
~~~

## 2.引用

然后在引用它的语句中设置 `resultMap` 属性就行了（注意我们去掉了 `resultType` 属性）。比如:

~~~xml
<select id="selectUsers" resultMap="userResultMap">
  select user_id, user_name, hashed_password
  from some_table
  where id = #{id}
</select>
~~~

# 5.使用注解

## 5.1在接口上写注解

```java
public interface UserMapper {

//    使用注解
    @Select("select * from user")
    List<User> getUserListAnnotate();
}
```

## 5.2进行绑定

~~~xml
<mappers>
    <mapper class="com.tuzhi.dao.UserMapper"/>
</mappers>
~~~

# 6.association和collection

association用于对象，关联

collection用于集合

## 6.1一对多

* 实体类

  ~~~java
  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public class Student {
      private int id;
      private String name;
      private Teacher teacher;
  }
  
  ~~~

  ~~~java
  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public class Teacher {
      private int id;
      private String name;
  }
  ~~~

* 第一种查询

  ~~~xml
  <!--    第一种多对一查询-->
  <select id="getUserList1" resultMap="studentTeacher1">
      select * from student
  </select>
  <resultMap id="studentTeacher1" type="Student">
      <association property="teacher" column="tid" select="getTeacherListById"/>
  </resultMap>
  <select id="getTeacherListById" resultType="Teacher">
      select * from teacher where id = #{tid}
  </select>
  ~~~

* 第二种查询

  ~~~xml
  <!--    第二种多对一查询-->
  <select id="getUserList2" resultMap="studentTeacher2">
      select s.id sid,s.name sname,t.id tid,t.name tname
      from student s,teacher t
      where s.tid = t.id
  </select>
  <resultMap id="studentTeacher2" type="Student">
      <result property="id" column="sid"/>
      <result property="name" column="sname"/>
      <association property="teacher" javaType="Teacher">
          <result property="id" column="tid"/>
          <result property="name" column="tname"/>
      </association>
  </resultMap>
  ~~~

## 6.2多对一

* 实体类

  ~~~java
  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public class Student {
      private int id;
      private String name;
  }
  
  ~~~

  ~~~ java
  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public class Teacher {
      private int id;
      private String name;
      private List<Student> student;
  }
  
  ~~~

* 第一种查询

  ~~~xml
  <!--    第一种查询-->
      <select id="getTeacherListById1" resultMap="teacherStudent1">
          select t.id id,t.name tname,s.id sid,s.name sname,s.tid tid
          from teacher t,student s
          where t.id=s.tid
      </select>
      <resultMap id="teacherStudent1" type="Teacher">
          <result property="id" column="id"/>
          <result property="name" column="tname"/>
          <collection property="student" ofType="Student">
              <result property="id" column="sid"/>
              <result property="name" column="sname"/>
          </collection>
      </resultMap>
  ~~~

* 第二种查询

  ~~~xml
  
  <!--    第二种查询-->
      <select id="getTeacherListById2" resultMap="teacherStudent2">
          select * from teacher where id = #{id}
      </select>
      <resultMap id="teacherStudent2" type="Teacher">
          <collection property="student" javaType="Arraylist" ofType="Student" column="id" select="getStudentList"/>
      </resultMap>
      <select id="getStudentList" resultType="Student">
          select * from student where tid = #{id}
      </select>
  ~~~

# 7.动态查询

## 7.1模糊查询if标签

* 接口

~~~java
//查询
List<Blog> getBlogIf(Map map);
~~~

* if

~~~xml
<!--    动态sql模糊查询-->
<select id="getBlogIf" parameterType="map" resultType="blog">
    select * from blog
    <where>
        <if test="title != null">
            and title like concat('%',#{title},'%')
        </if>
        <if test="author != null">
            and author like concat('%',#{author}.'%')
        </if>
    </where>

</select>
~~~

## 7.2更新数据set标签

* 接口

* set标签

  ~~~xml
  <!--    动态更新数据-->
  <update id="updateBlog" parameterType="Blog">
      update blog
      <set>
          <if test="title != null">
              title = #{title},
          </if>
          <if test="author != null">
              author = #{author},
          </if>
          <if test="views != null">
              views = #{views},
          </if>
      </set>
      where id = #{id}
  </update>
  ~~~

## 7.3Forech

* forech

  ~~~xml
  <select id="queryForeach" parameterType="map" resultType="Blog">
      select * from blog
      <where>
          <foreach collection="ids" item="id" open="and (" separator="or" close=")">
              id = #{id}
          </foreach>
      </where>
  </select>
  ~~~

* 测试

  ~~~java
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
  ~~~

  

# 8.二级缓存

## 8.1在mybatis-config.xml中开启全局缓存

~~~xml
<setting name="cacheEnabled" value="true"/>
~~~



## 8.1添加局部缓存，在xxMapper.xml中添加

~~~xml
<cache
  eviction="FIFO"
  flushInterval="60000"
  size="512"
  readOnly="true"/>
~~~

