package com.biqi.web;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xiebq 2018/10/15
 */
@Controller
@Slf4j
@Api(tags = {"页面跳转Api文档"})
public class PageConstantController {



    @RequestMapping("/403")
    public String unauthorizedRole(){
        System.out.println("------没有权限-------");
        return "403";
    }



    @RequestMapping("/404")
    public String unfind(){
        System.out.println("------没有请求路径-------");
        return "404";
    }

}
