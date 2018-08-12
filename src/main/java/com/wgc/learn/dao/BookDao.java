package com.wgc.learn.dao;

import com.wgc.learn.model.Book;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 8/11/2018.
 */
//@Component
public interface BookDao {
    /**
     * 获取所有书籍
     * @return
     */
    List<Book> listAllBooks();

    int deleteByPrimaryKey(Integer bookId);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
}
