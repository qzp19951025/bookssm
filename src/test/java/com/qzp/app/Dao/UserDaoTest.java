package com.qzp.app.Dao;

import com.qzp.app.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/8/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class UserDaoTest {
    @Autowired
   private  UserDao dao;
    @Test
    public void testLogin() throws Exception {
        User user = new User();
        user.setLoginname("qzp1995");
        user.setLoginpass("1234567");

        System.out.print(dao.login(user));
    }
}