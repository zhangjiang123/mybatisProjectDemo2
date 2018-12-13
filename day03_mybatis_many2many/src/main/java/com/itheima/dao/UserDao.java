package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

public interface UserDao {

     List<User> findAll();



     void delectUser(Integer id);

     User findById(Integer id);



}
