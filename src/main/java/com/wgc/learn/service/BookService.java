package com.wgc.learn.service;

import com.wgc.learn.model.Book;

import java.util.List;

/**
 * Created by Administrator on 8/11/2018.
 */

public interface BookService {
    /**
     * 查询所有的书籍信息
     * @return
     */
    public List<Book> listAllBooks();

    /**
     * 根据书ID查询书籍信息
     * @param bookId
     * @return
     */
    public Book queryBookById(Integer bookId);
}
