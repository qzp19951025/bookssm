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
    //����cid��ҳ��ѯ
    List<Book> listBooksByCategory(Category category, PageBean pb);

   int countBooksByCategory(Category category);
    //����bid��ѯ
    Book findBookByBid(String bid);
    //�������߷�ҳ��ѯ
    List<Book> listBooksByauthor(String author, PageBean<Book> pb);

    int countBooksByAuthor(String author);
    //���ݳ������ҳ��ѯ
    List<Book> listBooksByPress(String press, PageBean<Book> pb);

    int countBooksByPress(String press);
}
