package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author niyueyeee
 * @create 2019-04-03 22:02
 */
@Configuration()
@ComponentScan("com.itheima")
@EnableAspectJAutoProxy
public class SpringConfig {
}
