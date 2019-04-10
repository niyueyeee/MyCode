package com.itheima.contriller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author niyueyeee
 * @create 2019-04-08 10:38
 */
@RestController
public class QuickController {

    @RequestMapping("/ok")
    public String quick(){
        return "hao springboot";
    }

}