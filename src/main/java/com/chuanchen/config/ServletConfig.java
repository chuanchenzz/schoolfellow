package com.chuanchen.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by chuanchen-pc on 2017/2/28.
 */
@Configuration
@ComponentScan({"com.chuanchen.controller"})
@EnableWebMvc
public class ServletConfig {

}
