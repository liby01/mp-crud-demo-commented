package com.example.mpdemo.mapper; // Mapper 接口所在包

import com.baomidou.mybatisplus.core.mapper.BaseMapper; // 引入 MyBatis-Plus 的 BaseMapper（内置通用 CRUD）
import com.example.mpdemo.entity.User; // 引入实体类 User
import org.apache.ibatis.annotations.Mapper; // 引入 @Mapper 注解，让 Spring 扫描到 Mapper 接口

/**
 * UserMapper：继承 BaseMapper，即可获得单表的常用 CRUD 方法
 */
@Mapper // 标注为 MyBatis 的 Mapper 组件
public interface UserMapper extends BaseMapper<User> {} // 接口体可留空，通用 CRUD 由父接口提供
