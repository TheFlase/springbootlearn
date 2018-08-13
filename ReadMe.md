一、Introduction

just for springboot learning
1.springboot mvc
2.+mybatis+freemarker

二、initialize SQL:

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` int(11) NOT NULL,
  `book_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', 'java');
INSERT INTO `book` VALUES ('2', 'c#');
INSERT INTO `book` VALUES ('3', 'golang');

三、Query url:

1)springboot启动测试：http://localhost:8080/index/
2）查询图书列表：http://localhost:8080/book/listAllBooks
3)根据图书ID查找图书：http://localhost:8080/book/queryBookById/3
4)统一异常返回页面：http://localhost:8080/index/hello
5）统一异常返回json：http://localhost:8080/index/json