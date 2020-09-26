package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author luosong
 * @version 1.0
 * @date 2020/9/26 9:52
 */
@Controller
public class IndexController {

    // @RequestMapping({"/","/index.html"})  可以在自定义的试图解析器中拦截重定向
    public String index(){
        return "index";
    }
}
