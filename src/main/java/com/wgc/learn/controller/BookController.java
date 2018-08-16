package com.wgc.learn.controller;

import com.wgc.learn.model.Book;
import com.wgc.learn.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 8/11/2018.
 */
@Controller
@RequestMapping(value = "book/")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 查询所有书籍
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "listAllBooks", method = RequestMethod.GET)
    public String listAllBooks(Model model) {
        List<Book> list = bookService.listAllBooks();
        model.addAttribute("bookList", list);
        return "bookList";
    }

    /**
     * 根据书籍ID查找书籍信息
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "queryBookById/{id}", method = RequestMethod.GET)
    public String queryBookById(Model model, @PathVariable("id") int id) {
        Book book = bookService.queryBookById(id);
        model.addAttribute("book",book);
        return "book";
    }

    @RequestMapping("sendBook")
    @ResponseBody
    public String index(Model model){
        List<Book> list = bookService.listAllBooks();
        bookService.sendbookNamesMsg(list.toString());
        return list.toString();
    }
}
