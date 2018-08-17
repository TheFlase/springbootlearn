package com.wgc.learn.service.impl;

import com.wgc.learn.dao.BookDao;
import com.wgc.learn.model.Book;
import com.wgc.learn.mq.Producer;
import com.wgc.learn.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 8/11/2018.
 */
@Service
public class BookServiceImpl implements BookService{

    private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    private BookDao bookDao;

    @Autowired
    Producer producer;

    @Autowired
    private RedisTemplate redisTemplate;

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

    /**
     * 获取书籍逻辑：
     * 如果缓存存在，从缓存中获取书籍信息
     * 如果缓存不存在，从 DB 中获取书籍信息，然后插入缓存
     * @param bookId 书籍ID
     * @return
     */
    @Override
    public Book queryBookByIdFromRedis(Integer bookId) {
        // 从缓存中获取书籍信息
        String key = "book_" + bookId;
        Book book = null;
        ValueOperations<String,Book> operations = redisTemplate.opsForValue();

        //缓存存在
        boolean hasKey = redisTemplate.hasKey(key);

        if(hasKey){
            book = operations.get(key);
            LOGGER.info("BookServiceImpl.queryBookByIdFromRedis() : 从缓存中获取了书籍 >> " + book.toString());
            return book;
        }

        //缓存中不存在则去数据库查询
        book = bookDao.queryBookById(bookId);

        //插入缓存 如果用对象保存需要序列化.也可以考虑json格式化对象后保存进去
        operations.set(key,book,10, TimeUnit.SECONDS);
        return book;
    }
}
