package com.example.springbootmybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lhp on 17/9/12.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "redirect:/user/list";
    }

}
