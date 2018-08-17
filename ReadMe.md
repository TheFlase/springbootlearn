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

6）测试发送消息：http://localhost:8080/book/sendBook

7）redis根据书籍ID去redis获取书籍信息：http://localhost:8080/book/queryBookByIdFromRedis/2

四、安装rabbitMq
1)创建/usr/program/rabbitmq目录
2）进入该目录先安装erlang

wget http://packages.erlang-solutions.com/erlang-solutions-1.0-1.noarch.rpm

rpm -Uvh erlang-solutions-1.0-1.noarch.rpm

rpm --import http://packages.erlang-solutions.com/rpm/erlang_solutions.asc

sudo yum install -y erlang

3）到rabbitqm官网查找最新安装包并安装

官网地址：http://www.rabbitmq.com/install-rpm.html#downloads

编者下载了rabbitmq-server.noarch 0:3.7.7-1.el6

rpm --import http://www.rabbitmq.com/rabbitmq-signing-key-public.asc

yum install -y rabbitmq-server.noarch 0:3.7.7-1.el6


启动RabbitMQ服务
#service rabbitmq-server start
状态查看
#rabbitmqctl status
启用插件
#rabbitmq-plugins enable rabbitmq_management
重启服务
#service rabbitmq-server restart
添加帐号:name 密码:passwd
#rabbitmqctl add_user name passwd
赋予其administrator角色
#rabbitmqctl set_user_tags name administrator
设置权限
#rabbitmqctl set_permissions -p / name ".*" ".*" ".*"

设置开机启动：
#chkconfig rabbitmq-server on

4）修改配置：

查找默认配置位置：
find / -name "rabbitmq.config.example"，我这边搜索结果是：/usr/share/doc/rabbitmq-server-3.7.7/rabbitmq.config.example

复制默认配置：
cp /usr/share/doc/rabbitmq-server-3.7.7/rabbitmq.config.example /etc/rabbitmq/

修改配置文件名：
cd /etc/rabbitmq ; mv rabbitmq.config.example rabbitmq.config 

编辑配置文件，开启用户远程访问：
vim rabbitmq.config,在文档里面默认有这样一句话：%% {loopback_users, []},，注意，该语句最后有一个逗号，等下是要去掉的,我们需要改为：{loopback_users, []}，

开启 Web 界面管理：
rabbitmq-plugins enable rabbitmq_management

重启 RabbitMQ 服务：
service rabbitmq-server restart

开放防火墙端口（centos6为例）：
sudo iptables -I INPUT -p tcp -m tcp --dport 15672 -j ACCEPT

sudo iptables -I INPUT -p tcp -m tcp --dport 5672 -j ACCEPT

sudo service iptables save

sudo service iptables restart

浏览器访问：http://192.168.1.114:15672 默认管理员账号：guest 默认管理员密码：guest


