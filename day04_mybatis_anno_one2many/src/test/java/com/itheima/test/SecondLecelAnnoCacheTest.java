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

public class SecondLecelAnnoCacheTest {

    InputStream rs ;

    SqlSessionFactory factory;



    @Before
    public void init() throws IOException {


        rs = Resources.getResourceAsStream("SqlMapConfig.xml");

        factory  = new SqlSessionFactoryBuilder().build(rs);




    }

    @After
    public void destroy() throws IOException {


        rs.close();

    }




    @Test
    public void findById() {



        SqlSession session = factory.openSession();
        UserDao userDao = session.getMapper(UserDao.class);
        User user1 = userDao.findById(49);

        session.close();

        SqlSession session1 = factory.openSession();
        UserDao userDao1 = session1.getMapper(UserDao.class);
        User user2 = userDao1.findById(49);
//        User user2 = userDao.findById(49);

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user1==user2);
    }



}
