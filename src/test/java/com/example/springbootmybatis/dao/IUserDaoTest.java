package com.example.springbootmybatis.dao;

import com.example.springbootmybatis.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lhp on 17/9/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IUserDaoTest {

    @Resource
    private IUserDao userDao;


    @Test
    public void findOne() throws Exception {
        User user = userDao.findOne("lhp");
        System.out.println(user);
    }

    @Test
    public void updateUser() throws Exception {
        User user = new User();
        user.setUsername("lhp");
        user.setPassword("654321");
        userDao.updateUser(user);
        System.out.println(user);
    }

    @Test
    public void insertUser() throws Exception {
        User user = new User();
        user.setUsername("lhp");
        user.setPassword("123456");
        userDao.insertUser(user);
    }

    @Test
    public void list() throws Exception {
        List<User> users = userDao.listUser();
        System.out.println(users);
    }

    @Test
    public void delete() throws Exception {
        userDao.deleteUser("lhp");
    }

}