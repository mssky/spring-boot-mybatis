package com.example.springbootmybatis.dao;

import com.example.springbootmybatis.model.User;

import java.util.List;

/**
 * Created by lhp on 17/9/12.
 */
public interface IUserDao {

    //    @Select("select * from a_user where username=#{username}")
    User findOne(String username);

    //    @Insert("insert into a_user(username,password) values (#{username},#{password})")
    void insertUser(User user);

    //    @Update("update a_user set password = #{password} where username=#{username}")
    void updateUser(User user);

    //    @Select("select * from a_user order by username")
    List<User> listUser();

    //    @Delete("delete from a_user where username=#{username}")
    void deleteUser(String username);


}
