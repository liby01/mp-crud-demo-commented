package com.example.mpdemo.controller; // 控制器所在包

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper; // 引入 LambdaQueryWrapper：类型安全的条件构造器
import com.baomidou.mybatisplus.extension.plugins.pagination.Page; // 引入 Page：分页对象
import com.example.mpdemo.entity.User; // 引入 User 实体
import com.example.mpdemo.service.UserService; // 引入 UserService
import org.springframework.web.bind.annotation.*; // 引入 Web MVC 注解（RestController、RequestMapping、参数映射等）

/**
 * 用户控制器：提供最基础的 CRUD + 分页查询接口
 */
@RestController // 标记为 REST 风格控制器（返回 JSON）
@RequestMapping("/users") // 统一的请求前缀
public class UserController { // 控制器类定义
    private final UserService userService; // 注入服务层

    // 通过构造器注入 UserService（推荐做法，便于单元测试）
    public UserController(UserService userService) { // 构造器
        this.userService = userService; // 赋值给成员变量
    } // 构造器结束

    // ====== 新增（Create） ======
    @PostMapping // POST /users
    public User create(@RequestBody User u) { // 从请求体读取 JSON 并反序列化为 User
        userService.save(u); // 调用服务层保存数据（INSERT）
        return u; // 返回保存后的对象（包含生成的主键）
    } // create 结束

    // ====== 查询单个（Read by ID） ======
    @GetMapping("/{id}")
    public User detail(@PathVariable("id") Long id) {// 从路径变量获取 id
        return userService.getById(id);// 根据主键查询并返回
    }// detail 结束

    // ====== 更新（Update by ID） ======
    @PutMapping("/{id}") // PUT /users/{id}
    public boolean update(@PathVariable Long id, @RequestBody User u) { // 请求体携带要更新的数据
        u.setId(id); // 确保实体内包含要更新的主键
        return userService.updateById(u); // 执行按主键更新
    } // update 结束

    // ====== 删除（Delete by ID） ======
    @DeleteMapping("/{id}") // DELETE /users/{id}
    public boolean delete(@PathVariable Long id) { // 从路径变量解析主键
        return userService.removeById(id); // 执行按主键删除
    } // delete 结束

    // ====== 分页 + 条件查询（按名称模糊） ======
    @GetMapping // GET /users?page=1&size=10&name=abc
    public Page<User> page(@RequestParam(defaultValue = "1") long page, // 页码，默认 1
                           @RequestParam(defaultValue = "10") long size, // 每页大小，默认 10
                           @RequestParam(required = false) String name) { // 可选的名称过滤
        LambdaQueryWrapper<User> qw = new LambdaQueryWrapper<>(); // 创建查询条件构造器
        // 若 name 非空，则按名称模糊查询；并按 id 倒序排列
        qw.like(name != null && !name.isBlank(), User::getName, name)
          .orderByDesc(User::getId);
        // 执行分页查询并返回结果
        return userService.page(Page.of(page, size), qw);
    } // page 结束
} // 控制器类结束
