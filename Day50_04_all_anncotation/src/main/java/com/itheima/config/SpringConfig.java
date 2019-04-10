package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author niyueyeee
 * @create 2019-04-02 22:00
 */
@Configuration
@ComponentScan("com.itheima")
@Import(value = {JDBCConfig.class})
public class SpringConfig {
}
