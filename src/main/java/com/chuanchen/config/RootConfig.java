package com.chuanchen.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by chuanchen-pc on 2017/2/28.
 */
@Configuration
@ComponentScan(basePackages = "com.chuanchen")
@PropertySource("classpath:/dbcp.properties")
public class RootConfig {
    @Autowired
    Environment environment;
    @Bean
    public BasicDataSource dataSource(){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(environment.getProperty("classDriver"));
        basicDataSource.setUrl(environment.getProperty("url"));
        basicDataSource.setUsername(environment.getProperty("userName"));
        basicDataSource.setPassword(environment.getProperty("password"));
        basicDataSource.setInitialSize(Integer.valueOf(environment.getProperty("initialSize")));
        basicDataSource.setMaxTotal(Integer.valueOf(environment.getProperty("maxTotal")));
        return basicDataSource;
    }
    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
}
