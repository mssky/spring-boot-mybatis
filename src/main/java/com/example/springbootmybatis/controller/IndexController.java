package com.example.springbootmybatis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lhp on 17/9/12.
 */
@RestController
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "hello, world.";
    }

}
