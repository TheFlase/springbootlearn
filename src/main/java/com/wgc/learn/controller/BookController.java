package com.wgc.learn.controller;

import com.wgc.learn.model.Book;
import com.wgc.learn.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 8/11/2018.
 */
@Controller
@RequestMapping(value = "book/")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "listAllBooks")
    @ResponseBody
    public Map<String,Object> listAllBooks(){
        Map<String,Object> resultMap= new HashMap<String,Object>();
        List<Book> list = bookService.listAllBooks();
        resultMap.put("list",list);
        resultMap.put("flag",true);
        return resultMap;
    }
}
