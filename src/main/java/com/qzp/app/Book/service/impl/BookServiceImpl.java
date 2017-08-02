package com.qzp.app.Book.service.impl;



import com.qzp.app.Book.service.BookService;
import com.qzp.app.Dao.BookDao;
import com.qzp.app.common.PageBean;
import com.qzp.app.entity.Book;
import com.qzp.app.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/24.
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao dao;
    private int pageSize;
    private  int start;
    @Override
    public List<Book> listBooksByCategory(Category category,PageBean pb) {
         pageSize = pb.getPageSize();
         start = (pb.getPageNumber() - 1) * pageSize;
        List<Book> list = dao.listBooksByCategory(category,start,pageSize);
        return list;
    }
    @Override
    public int countBooksByCategory(Category category) {
        return dao.countBooksByCategory(category);
    }

    @Override
    public Book findBookByBid(String bid) {

        return dao.findBookByBid(bid);
    }

    @Override
    public List<Book> listBooksByauthor(String author, PageBean<Book> pb) {
       pageSize = pb.getPageSize();
        start = (pb.getPageNumber() - 1) * pageSize;
        List<Book> list = dao.listBooksByauthor(pageSize,start, author);
        return list;
    }

    @Override
    public int countBooksByAuthor(String author) {
        return dao.countBooksByAuthor(author);
    }

    @Override
    public List<Book> listBooksByPress(String press, PageBean<Book> pb) {
        pageSize = pb.getPageSize();
        start = (pb.getPageNumber() - 1) * pageSize;
        List<Book> list = dao.listBooksByPress(pageSize, start, press);
        return list;
    }

    @Override
    public int countBooksByPress(String press) {
        return dao.countBooksByPress(press);
    }
}
