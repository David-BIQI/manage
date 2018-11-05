package com.biqi.web;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xiebq 2018/10/16
 */
@Controller
@Slf4j
@Api(tags = {"页面跳转Api文档"})
public class PageJumpController {

    @RequestMapping("/index")
    public String index(){
        return "login";
    }


    @RequestMapping("/main")
    public String main(){
        return"/main";
    }


    @RequestMapping("/login")
    public String login(){
        return"/login";
    }






}
