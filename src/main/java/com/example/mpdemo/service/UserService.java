package com.example.mpdemo.service; // Service 接口所在包

import com.baomidou.mybatisplus.extension.service.IService; // 引入 IService：提供更丰富的服务层封装
import com.example.mpdemo.entity.User; // 引入 User 实体

/**
 * UserService：继承 IService<User>，拥有通用的服务层方法
 */
public interface UserService extends IService<User> {} // 接口留空，方法由父接口与实现类提供
