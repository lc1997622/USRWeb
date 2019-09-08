package com.example.usrweb.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantHandler;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantSqlParser;
import net.sf.jsqlparser.expression.Expression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;

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
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();

        ArrayList<ISqlParser> sqlParserList = new ArrayList<>();
        TenantSqlParser tenantSqlParser = new TenantSqlParser();
        tenantSqlParser.setTenantHandler(new TenantHandler() {
            @Override
            public Expression getTenantId(boolean where) {
                return null;
            }

            @Override
            public String getTenantIdColumn() {
                return null;
            }

            @Override
            public boolean doTableFilter(String tableName) {
                return false;
            }
        });
        return new PaginationInterceptor();
    }
}
