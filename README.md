* Redis 在 Spring Boot 中两个典型的应用场景：数据缓存、共享Session。

### 步骤一：创建项目
一、构建工具选择：maven 

二、使用 Spring Initializr 创建此 Spring Boot 项目时，Dependencies 选择了：
1. Spring Boot DevTools
2. Spring Web Starter
3. Spring Session
4. MySQL Driver
5. JDBC API
6. MyBatis Framework
7. Spring Data Redis(Access+Driver)
8. Spring Boot Actuator
9. Spring Boot Admin(Client)
10. Spring Boot Admin(Server)

### 步骤二：mysql 的 docker 镜像使用
1.下载镜像：
```
$ docker pull mysql:8.0.13
```
2.创建一个 mysql 容器
```
$ docker run -e MYSQL_ROOT_PASSWORD=root -p 3306:3306 -d mysql:8.0.13
```
3.查看 mysql 容器的相关信息，会看到容器id、容器name
```
$ docker ps
```
4.进入创建的 mysql 容器的 bash，容器id或name为第3步骤看到的
```
$ docker exec -it yourContainerId或yourContainerName bash
```
5.进入 mysql 命令行，会提示输入 root 用户的密码（即第2步骤配置的：root）
```
$ mysql -uroot -proot
```
6.即可进行 mysql 数据库的管理工作
* 出处：https://hub.docker.com/_/mysql

### 步骤三：数据库管理工作
1.查看有几个数据库
```
mysql> show databases;
```
2.创建一个数据库
```
mysql> create database mysql_test;
```
3.查看数据库 mysql_test 的建库语句
```
mysql> show create database mysql_test\G
```
4.切换到某个数据库
```
mysql> use mysql_test;
```
5.查看数据库相关信息
```
mysql> status;
```
6.创建 users 表
```
mysql> CREATE TABLE `users` (
         `id` bigint(20)  AUTO_INCREMENT    NOT NULL COMMENT '主键id',
         `userName` varchar(32)  DEFAULT '' NOT NULL COMMENT '用户名',
         `passWord` varchar(32)  DEFAULT '' NOT NULL COMMENT '密码',
         `user_sex` varchar(32)  DEFAULT '' NOT NULL COMMENT '性别',
         `nick_name` varchar(32) DEFAULT '' NOT NULL COMMENT '昵称',
         PRIMARY KEY (`id`)
       ) ENGINE=InnoDB AUTO_INCREMENT=28;
```
7.查看 users 表信息
```
mysql> desc users;
```
8.查看 users 表的建表语句
```
mysql> show create table users\G
```
9.查询 users 表
```
mysql> select * from users;
```

### 步骤四：开发过程中的单元测试
1. 执行 src/test/java/tk/mybatis/springboot/controller/UserControllerTest
.java、src/test/java/tk/mybatis/springboot/mapper/UserMapperTest.java 中的测试用例

### 步骤五：启动项目，访问接口
1. 运行：src/main/java/tk/mybatis/springboot/SpringbootApplication.java，或双击：maven->Plugins->spring-boot->spring-boot:run
2. 访问首页及各地址：http://localhost:8080/

### 步骤六：配置 Swagger 接口文档，并在 swagger-ui 上测试接口
1. 参考：http://blog.didispace.com/springbootswagger2/
2. 访问 swagger-ui：http://localhost:8080/swagger-ui.html

### 步骤七：配置 devTools
1. 参考：https://www.cnblogs.com/cag2050/p/7884745.html

### 步骤八：配置 Redis 缓存
1.在pom.xml中引入cache依赖，添加如下内容：
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```
2.tk/mybatis/springboot/mapper/UserMapper.java 中 getAll 方法加注解 @Cacheable 时，redis中存在的key为：`users::SimpleKey
 []`；加注解 @Cacheable(value="user-key") 时，redis中存在的key为：`user-key::SimpleKey []`；加注解 @Cacheable，并添加 tk/mybatis/springboot
 /config/RedisConfig.java 时，redis中存在的key为：`users::com.sun.proxy.$Proxy105getAll`。
 3.


> 参考：[Spring Boot(三)：Spring Boot 中 Redis 的使用](http://www.ityouknow.com/springboot/2016/03/06/spring-boot-redis.html)