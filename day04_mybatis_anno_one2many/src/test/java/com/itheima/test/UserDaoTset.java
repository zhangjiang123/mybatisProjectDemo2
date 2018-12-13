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
            System.out.println(user.getAccounts());
        }


    }

    @Test
    public void findById() {

        User user = new User();
        User user1 = userDao.findById(49);

        User user2 = userDao.findById(49);


        System.out.println(user1);
        System.out.println(user2);
    }


    @Test
    public void findUserByName() {

        User user = new User();
        List<User> userbyName = userDao.findUserByName("王");

        for (User user1 : userbyName) {
            System.out.println(user1);
        }
    }






}
