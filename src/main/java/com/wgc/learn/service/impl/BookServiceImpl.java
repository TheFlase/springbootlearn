package com.wgc.learn.service.impl;

import com.wgc.learn.dao.BookDao;
import com.wgc.learn.model.Book;
import com.wgc.learn.mq.Producer;
import com.wgc.learn.service.BookService;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 8/11/2018.
 */
@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDao bookDao;

    @Autowired
    Producer producer;

    @Value("${myqueue}")
    String queue;

    @Bean
    Queue queue(){
        return new Queue(queue,true);
    }

    @Override
    public List<Book> listAllBooks() {
        return bookDao.listAllBooks();
    }

    @Override
    public Book queryBookById(Integer bookId) {
        return bookDao.queryBookById(bookId);
    }

    public void  sendbookNamesMsg(String msg){
        System.out.println("开始发送消息。。。。。。。");
        producer.sendTo(queue,  msg+" at " + new Date());
    }
}
