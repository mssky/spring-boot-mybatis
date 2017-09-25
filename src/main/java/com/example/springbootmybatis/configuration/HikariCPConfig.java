package com.example.springbootmybatis.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
public class HikariCPConfig {

    @Resource
    private Environment environment;

    @Bean
    public DataSource dataSource() {
        HikariConfig configuration = new HikariConfig();
        configuration.setPoolName(environment.getProperty("hikari.poolName"));
        configuration.setMinimumIdle(5);
        configuration.setMaximumPoolSize(25);
        configuration.setConnectionTimeout(30000);
        configuration.setIdleTimeout(30000);
        configuration.setJdbcUrl(environment.getProperty("hikari.dataSourceProperties.url"));
        configuration.setDriverClassName(environment.getProperty("hikari.dataSourceClassName"));
        configuration.setConnectionTestQuery(environment.getProperty("hikari.connectionTestQuery"));
        configuration.addDataSourceProperty("user", environment.getProperty("hikari.dataSourceProperties.user"));
        configuration.addDataSourceProperty("password", environment.getProperty("hikari.dataSourceProperties.password"));
        configuration.addDataSourceProperty("cachePrepStmts", environment.getProperty("hikari.dataSourceProperties.cachePrepStmts"));
        configuration.addDataSourceProperty("prepStmtCacheSize", environment.getProperty("hikari.dataSourceProperties.prepStmtCacheSize"));
        configuration.addDataSourceProperty("prepStmtCacheSqlLimit", environment.getProperty("hikari.dataSourceProperties.prepStmtCacheSqlLimit"));
        return new HikariDataSource(configuration);
    }

}