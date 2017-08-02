package com.qzp.app.Book.service;


import com.qzp.app.common.PageBean;
import com.qzp.app.entity.Book;
import com.qzp.app.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/24.
 */
public interface BookService {
    //根据cid分页查询
    List<Book> listBooksByCategory(Category category, PageBean pb);

   int countBooksByCategory(Category category);
    //根据bid查询
    Book findBookByBid(String bid);
    //根据作者分页查询
    List<Book> listBooksByauthor(String author, PageBean<Book> pb);

    int countBooksByAuthor(String author);
    //根据出版社分页查询
    List<Book> listBooksByPress(String press, PageBean<Book> pb);

    int countBooksByPress(String press);
}
