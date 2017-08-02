package com.qzp.app.Book.action;

import com.qzp.app.Book.service.BookService;
import com.qzp.app.common.PageBean;
import com.qzp.app.common.PropKit;
import com.qzp.app.common.StrKit;
import com.qzp.app.entity.Book;
import com.qzp.app.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/7/24.
 */


@Controller
@Scope("prototype")
@RequestMapping("/bookAction")
public class BookAction {
    @Autowired
    private BookService servive;
    private PageBean<Book> pb = new PageBean<Book>();
    @RequestMapping("/listBooksByCategory")
    public String listBooksByCategory(@ModelAttribute Category category, HttpServletRequest request) {


        //第一步：获取前台传递过来的pageNumber(当前页的页码)
        pb.setPageNumber(this.getPageNumber(request));
        //第二步：获取前台传递过来的url(为什么要动态获取url?)
        pb.setUrl(this.getUrl(request));

        //第三步：获取pageSize(每页显示的条数)
        //PropKit专门用户获取properties文件的内容
        pb.setPageSize(PropKit.use("pageSize.properties").getInt("book_page_size"));
        //第四步：获取list(指定页码的书籍的集合)
        //在括号的内部调用业务逻辑层接口中的方法
        List<Book> list = servive.listBooksByCategory(category, pb);
        pb.setList(list);
        //第五步：获取totalRecords(查询符合条件记录总数，符合cid的记录总条数)
        //在括号的内部调用业务逻辑层接口中的方法
        pb.setTotalRecords(servive.countBooksByCategory(category));
        //把数据准备好存放到request范围中，转发到如下页面
        request.setAttribute("pb", pb);
        System.out.println(pb.getUrl());
        return "forward:/jsps/book/list.jsp";
    }


//根据Bid查询书籍
    @RequestMapping("/listBooksByBid")
    public String listBooksByBid(@RequestParam("bid") String bid,Model model) {
        System.out.println(bid);
        Book book = servive.findBookByBid(bid);

        model.addAttribute("book",book);

        return "forward:/jsps/book/desc.jsp";
    }
    //根据作者名分页查询
    @RequestMapping("/listBooksByauthor")
    public String listBooksByauthor(@RequestParam("author")String author , HttpServletRequest request) {


        //第一步：获取前台传递过来的pageNumber(当前页的页码)
        pb.setPageNumber(this.getPageNumber(request));
        //第二步：获取前台传递过来的url(为什么要动态获取url?)
        pb.setUrl(this.getUrl(request));

        //第三步：获取pageSize(每页显示的条数)
        //PropKit专门用户获取properties文件的内容
        pb.setPageSize(PropKit.use("pageSize.properties").getInt("book_page_size"));
        //第四步：获取list(指定页码的书籍的集合)
        //在括号的内部调用业务逻辑层接口中的方法
        List<Book> list = servive.listBooksByauthor(author, pb);
        pb.setList(list);
        //第五步：获取totalRecords(查询符合条件记录总数，符合cid的记录总条数)
        //在括号的内部调用业务逻辑层接口中的方法
        pb.setTotalRecords(servive.countBooksByAuthor(author));
        //把数据准备好存放到request范围中，转发到如下页面
        request.setAttribute("pb", pb);
        System.out.println(pb.getUrl());
        return "forward:/jsps/book/list.jsp";
    }
//根据出版社查询

    @RequestMapping("/listBooksByPress")
    public String listBooksByPress(@RequestParam("press")String press , HttpServletRequest request) {


        //第一步：获取前台传递过来的pageNumber(当前页的页码)
        pb.setPageNumber(this.getPageNumber(request));
        //第二步：获取前台传递过来的url(为什么要动态获取url?)
        pb.setUrl(this.getUrl(request));

        //第三步：获取pageSize(每页显示的条数)
        //PropKit专门用户获取properties文件的内容
        pb.setPageSize(PropKit.use("pageSize.properties").getInt("book_page_size"));
        //第四步：获取list(指定页码的书籍的集合)
        //在括号的内部调用业务逻辑层接口中的方法
        List<Book> list = servive.listBooksByPress(press, pb);
        pb.setList(list);
        //第五步：获取totalRecords(查询符合条件记录总数，符合cid的记录总条数)
        //在括号的内部调用业务逻辑层接口中的方法
        pb.setTotalRecords(servive.countBooksByPress(press));
        //把数据准备好存放到request范围中，转发到如下页面
        request.setAttribute("pb", pb);
        System.out.println(pb.getUrl());
        return "forward:/jsps/book/list.jsp";
    }

    private String getUrl(HttpServletRequest request) {
        String uri = request.getRequestURI();//    /appmvc/bookAction/ListBooksByCategory
        //  request.getRequestURL()      http://localhost/appmvc/bookAction/ListBooksByCategory.do?bname=lol&pageNumber = 2
        String queryString = request.getQueryString();       // cid = XXX
        if (queryString == null) {
            return uri;
        } else {
            if (queryString.indexOf("pageNumber=") == 0) {
                return uri;
            }
            if (queryString.contains("&pageNumber")) {

                System.out.print(queryString.lastIndexOf("&pageNumber"));
                return uri + "?" + queryString.substring(0, queryString.lastIndexOf("&pageNumber"));
            }
            return uri + "?" + queryString;
        }
    }

    private int getPageNumber(HttpServletRequest request) {
        String pageNumberStr = request.getParameter("pageNumber");

        try {
            if (StrKit.notBlank(pageNumberStr)) {
                return Integer.parseInt(pageNumberStr);
            } else {
                return 1;
            }
        } catch (Exception e) {
            throw  new RuntimeException(e.getMessage());
        }
    }
}
