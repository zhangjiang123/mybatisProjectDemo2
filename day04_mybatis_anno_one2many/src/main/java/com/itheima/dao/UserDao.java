package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@CacheNamespace(blocking = true)
public interface UserDao {


    @Select("select * from user")
    @Results(id="userMap",value={
            @Result(id=true,column ="id",property = "userId"),
            @Result(column ="username",property = "userName"),
            @Result(column ="address",property = "userAddress"),
            @Result(column ="sex",property = "userSex"),
            @Result(column ="birthday",property = "userBirthday"),
            @Result(property = "accounts" ,column = "id" ,many = @Many(select="com.itheima.dao.AccountDao.findAccountById",fetchType = FetchType.EAGER))
    })
    List<User> findAll();

    @Insert("insert into user(username,address,sex,birthday) values(#{username},#{address},#{sex},#{birthday})")
    void saveUser(User user);

    @Update("update user set username=#{username},address=#{address},sex=#{sex},birthday=#{birthday} where id =#{id}")
    void updateUser(User user);

    @Select("select * from user where id = #{id}")
    @ResultMap("userMap")
    User findById(Integer userId);

    @Select("select * from user where username like '%${value}%'")
    List<User> findUserByName(String username);



}
