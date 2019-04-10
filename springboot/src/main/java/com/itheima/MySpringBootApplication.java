package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author niyueyeee
 * @create 2019-04-08 10:38
 */
@SpringBootApplication
public class  MySpringBootApplication {

    public static void main(String[] args) {
        //run方法 表示运行SpringBoot的引导类  run参数就是SpringBoot引导类的字节码对象
        SpringApplication.run(MySpringBootApplication.class);
    }


}
