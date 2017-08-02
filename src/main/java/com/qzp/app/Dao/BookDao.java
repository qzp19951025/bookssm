package com.qzp.app.Dao;


import com.qzp.app.entity.Book;
import com.qzp.app.entity.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/7/24.
 */
public interface BookDao {
    List<Book> listBooksByCategory(@Param("category") Category category, @Param("start") int start, @Param("pageSize") int pageSize);

    int countBooksByCategory(@Param("category") Category category);

    Book findBookByBid(String bid);

    List<Book> listBooksByauthor(@Param("pageSize")int pageSize, @Param("start")int start, @Param("author")String author);

    int countBooksByAuthor(String author);

    List<Book> listBooksByPress(@Param("pageSize")int pageSize, @Param("start")int start, @Param("press")String press);

    int countBooksByPress(String press);
}
