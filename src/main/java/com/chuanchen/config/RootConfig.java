package com.chuanchen.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * Created by chuanchen-pc on 2017/2/28.
 */
@Configuration
@ComponentScan(basePackages = "com.chuanchen")
@PropertySource("classpath:dbcp.properties")
public class RootConfig {
    @Autowired
    Environment environment;
    @Bean
    public BasicDataSource dataSource(){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(environment.getProperty("driver"));
        basicDataSource.setUrl(environment.getProperty("jdbc.url"));
        basicDataSource.setUsername(environment.getProperty("jdbc.userName"));
        basicDataSource.setPassword(environment.getProperty("jdbc.password"));
        basicDataSource.setInitialSize(Integer.valueOf(environment.getProperty("initialSize")));
        basicDataSource.setMaxWait(Integer.valueOf(environment.getProperty("maxWait")));
        return basicDataSource;
    }
    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
    @Bean
    public MultipartResolver multipartResolver() throws IOException{
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setUploadTempDir(new FileSystemResource(""));
        commonsMultipartResolver.setMaxUploadSize(2097152);
        commonsMultipartResolver.setMaxInMemorySize(0);
        commonsMultipartResolver.setDefaultEncoding("UTF-8");
        return commonsMultipartResolver;
    }
}
