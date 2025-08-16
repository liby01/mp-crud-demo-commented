package com.example.mpdemo; // 声明包名，按目录结构对应

import org.springframework.boot.SpringApplication; // 引入 SpringApplication，提供启动入口
import org.springframework.boot.autoconfigure.SpringBootApplication; // 引入 @SpringBootApplication 注解

/**
 * 应用启动类（main 方法入口）
 */
@SpringBootApplication // 标注为 Spring Boot 应用：自动配置、组件扫描等
public class MpdemoApplication { // 定义启动类
    public static void main(String[] args) { // Java 应用主入口方法
        SpringApplication.run(MpdemoApplication.class, args); // 启动 Spring 应用（创建容器，启动内置 Tomcat）
    } // main 方法结束
} // 启动类结束
