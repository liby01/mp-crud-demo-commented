# mp-crud-demo（行级中文注释版）

这是一个使用 **Java 17 + Spring Boot 3.2.5 + MyBatis-Plus 3.5.5 + MySQL 8** 的最小 CRUD 项目。项目中 **每一行** pom、yml、Java 代码都加了中文注释，方便学习。

## 快速开始
1. 导入 `schema.sql` 到 MySQL，或手动执行里面的 SQL 建库建表。
2. 修改 `src/main/resources/application.yml` 的数据库连接（账号/密码/主机/端口）。
3. 运行：
   ```bash
   mvn spring-boot:run
   ```
4. 测试接口：
   - 新增：`POST /users`  Body(JSON)：`{"name":"Alice","email":"alice@test.com","age":20}`
   - 查询：`GET /users/1`
   - 更新：`PUT /users/1` Body(JSON)：`{"name":"Alice2","age":21}`
   - 删除：`DELETE /users/1`
   - 分页：`GET /users?page=1&size=10&name=Ali`
   
5. 建库建表
   -- ① 建库（如果已存在就跳过这步）
   CREATE DATABASE IF NOT EXISTS mp_demo
   DEFAULT CHARACTER SET utf8mb4
   DEFAULT COLLATE utf8mb4_general_ci;

   -- ② 选库
   USE mp_demo;
   
   -- ③ 建表 user
   DROP TABLE IF EXISTS `user`;
   CREATE TABLE `user` (
   id          BIGINT PRIMARY KEY AUTO_INCREMENT,   -- 主键，自增
   name        VARCHAR(64)  NOT NULL,               -- 姓名
   email       VARCHAR(128) UNIQUE,                 -- 邮箱（示例设为唯一）
   age         INT DEFAULT 0,                       -- 年龄
   created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP  -- 创建时间
   ) ENGINE=InnoDB
   DEFAULT CHARSET = utf8mb4
   COLLATE = utf8mb4_general_ci;
