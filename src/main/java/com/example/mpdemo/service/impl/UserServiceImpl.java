package com.example.mpdemo.service.impl; // Service 实现所在包

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl; // 引入 ServiceImpl：IService 的默认实现
import com.example.mpdemo.entity.User; // 引入 User 实体
import com.example.mpdemo.mapper.UserMapper; // 引入 UserMapper
import com.example.mpdemo.service.UserService; // 引入 UserService 接口
import org.springframework.stereotype.Service; // 引入 @Service 注解，标记为服务组件

/**
 * UserService 实现类：继承 ServiceImpl，指定 Mapper 与实体类型
 */
@Service // 注册为 Spring 组件
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService { // 实现类定义
    // 无需额外代码，父类已实现常见 CRUD，若有业务逻辑可在此扩展
} // 实现类结束
