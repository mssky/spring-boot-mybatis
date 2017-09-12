package com.example.springbootmybatis.controller;

import com.example.springbootmybatis.model.User;
import com.example.springbootmybatis.service.IUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by lhp on 17/9/12.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping("/list")
    public String list(Model model,
                       Integer currentPage,
                       Integer pageSize) {

        PageInfo<User> userPageInfo = userService.listUser(currentPage, pageSize);
        model.addAttribute("pageInfo", userPageInfo);

        return "/user/user_list";
    }

    @RequestMapping("/save")
    public String list(User user) {

        userService.saveUser(user);

        return "redirect:/user/list";
    }

    @RequestMapping("/delete")
    public String list(String username) {

        userService.deleteUser(username);

        return "redirect:/user/list";
    }
}
