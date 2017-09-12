package com.example.springbootmybatis.service;

import com.example.springbootmybatis.model.User;
import com.github.pagehelper.PageInfo;

/**
 * Created by lhp on 17/9/12.
 */
public interface IUserService {
    void saveUser(User user);

    void deleteUser(String username);

    PageInfo<User> listUser(Integer currentPage, Integer pageSize);
}
