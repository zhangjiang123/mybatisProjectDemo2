package com.itheima.test;

import com.itheima.dao.AccountDao;
import com.itheima.dao.UserDao;
import com.itheima.domain.Account;
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

public class AccountDaoTest  {


    InputStream rs ;

    SqlSession session;
    AccountDao accountDao;

    @Before
    public void init() throws IOException {


        rs = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory factory  = new SqlSessionFactoryBuilder().build(rs);

        session = factory.openSession();

        accountDao= session.getMapper(AccountDao.class);


    }

    @After
    public void destroy() throws IOException {

        session.commit();

        session.close();
        rs.close();

    }

    @Test
    public void findAllTest(){


        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
            System.out.println(account.getUser());
        }


    }


}
