package com.example.springbootmybatis.service.impl;

import com.example.springbootmybatis.dao.IUserDao;
import com.example.springbootmybatis.model.User;
import com.example.springbootmybatis.service.IUserService;
import com.example.springbootmybatis.util.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lhp on 17/9/12.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    @Override
    public void saveUser(User user) {
        String username = user.getUsername();
        if (userDao.findOne(username) != null) {
            userDao.updateUser(user);
        } else {
            userDao.insertUser(user);
        }
    }

    @Override
    public void deleteUser(String username) {
        userDao.deleteUser(username);
    }

    @Override
    public PageInfo<User> listUser(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(PageUtil.getCurrentPage(currentPage), PageUtil.getPageSize(pageSize));
        List<User> userList = userDao.listUser();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }
}
