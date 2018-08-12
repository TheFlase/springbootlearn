package com.wgc.learn.service.impl;

import com.wgc.learn.dao.BookDao;
import com.wgc.learn.model.Book;
import com.wgc.learn.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 8/11/2018.
 */
@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> listAllBooks() {
        return bookDao.listAllBooks();
    }
}
