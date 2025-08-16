-- 在 MySQL 中创建示例数据库与表（带注释）

-- 若不存在则创建名为 mp_demo 的数据库，并统一字符集为 utf8mb4（兼容 emoji）
CREATE DATABASE IF NOT EXISTS mp_demo DEFAULT CHARACTER SET utf8mb4;
-- 切换到该数据库
USE mp_demo;

-- 创建用户表 user
CREATE TABLE user (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,        -- 主键，自增
  name VARCHAR(64) NOT NULL,                   -- 用户名，非空
  email VARCHAR(128) UNIQUE,                   -- 邮箱，示例设为唯一
  age INT DEFAULT 0,                           -- 年龄，默认 0
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP  -- 创建时间，默认当前时间
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;       -- 使用 InnoDB 引擎与 utf8mb4 字符集
