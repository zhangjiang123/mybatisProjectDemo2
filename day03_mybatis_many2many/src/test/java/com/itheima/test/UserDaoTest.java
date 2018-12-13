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

public class  UserDaoTest {


    InputStream   is = null;

    SqlSession session =null;

    UserDao userDao = null;



    @Before
    public void init() throws Exception{


        is= Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory factory= new SqlSessionFactoryBuilder().build(is);

        session = factory.openSession();
        userDao = session.getMapper(UserDao.class);



    }

    @After
    public void destory() throws IOException {


        session.commit();
        session.close();
        is.close();

    }


    @Test
    public void findAllTest()  {

        List<User> users = userDao.findAll();

        for (User user : users) {
            System.out.println(user);
            System.out.println(user.getRoles());

        }

    }



}
