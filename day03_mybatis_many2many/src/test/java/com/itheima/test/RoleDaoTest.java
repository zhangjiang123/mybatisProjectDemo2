package com.itheima.test;


import com.itheima.dao.RoleDao;
import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.domain.role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.management.relation.Role;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class RoleDaoTest {


    InputStream   is = null;

    SqlSession session =null;

    UserDao userDao = null;

    RoleDao roleDao = null;



    @Before
    public void init() throws Exception{

        is= Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory factory= new SqlSessionFactoryBuilder().build(is);

        session = factory.openSession();
        userDao = session.getMapper(UserDao.class);

        roleDao = session.getMapper(RoleDao.class);

    }

    @After
    public void destory() throws IOException {


        session.commit();
        session.close();
        is.close();

    }


    @Test
    public void findAllTest()  {

        List<role> roles = roleDao.findAll();

        for (role role : roles) {
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }



}
