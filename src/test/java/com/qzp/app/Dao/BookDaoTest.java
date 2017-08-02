package com.qzp.app.Dao;

import com.qzp.app.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/7/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class BookDaoTest {

        @Autowired
        private BookDao bookdao;

        @Test
        public void testListCategories() throws Exception {
            System.out.println(bookdao.findBookByBid("000A18FDB38F470DBE9CD0972BADB23F"));
        }

    }