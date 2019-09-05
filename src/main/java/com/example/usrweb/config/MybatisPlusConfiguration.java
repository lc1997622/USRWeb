package com.example.usrweb.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author ：LiChao
 * @date ：Created in 2019/9/3 20:20
 * @description：Mybatis-plus 配置
 * @modified By：
 * @version: 1.0$
 */

@Configuration
public class MybatisPlusConfiguration {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
