package com.example.mpdemo.entity; // 实体类所在包

import com.baomidou.mybatisplus.annotation.TableName; // 引入 MyBatis-Plus 的 @TableName 注解
import lombok.Data; // 引入 Lombok 的 @Data 注解，自动生成 getter/setter/toString 等

/**
 * 用户实体类，对应数据库表 `user`
 */
@Data // 自动生成常用方法，减少样板代码
@TableName("user") // 指定映射的表名为 `user`
public class User { // 定义 User 实体
    private Long id; // 主键 ID（AUTO_INCREMENT）
    private String name; // 用户名称
    private String email; // 邮箱（示例里可唯一）
    private Integer age; // 年龄
    private java.time.LocalDateTime createdAt; // 创建时间（映射 created_at，启用驼峰映射）
} // User 实体结束
