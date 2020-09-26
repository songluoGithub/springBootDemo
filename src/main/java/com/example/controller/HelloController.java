package com.example.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luosong
 * @version 1.0
 * @date 2020/9/24 10:38
 */
@Controller
public class HelloController {

    @RequestMapping("/t1")
    public String hello(Model model){
        model.addAttribute("msg","helloSpringBoot");
        return "test";
    }
}
