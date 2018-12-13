package com.itheima.test;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserDaoTset {

    InputStream rs ;

    SqlSession session;
    UserDao userDao;

    @Before
    public void init() throws IOException {


        rs = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory factory  = new SqlSessionFactoryBuilder().build(rs);

        session = factory.openSession();

        userDao = session.getMapper(UserDao.class);


    }

    @After
    public void destroy() throws IOException {

        session.commit();

        session.close();
        rs.close();

    }



    @Test
    public void findAllTest(){


        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }


    }

    @Test
    public void saveUser() {

        User user = new User();
        user.setUsername("张三");
        user.setAddress("杭州");
        userDao.saveUser(user);
    }

    @Test
    public void updateUser() {

        User user = new User();
        user.setId(57);
        user.setUsername("李四");
        user.setAddress("苍南");
        userDao.updateUser(user);
    }



}
