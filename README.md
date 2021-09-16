# javawiki
>>> javawikiTest
## 相关 npm 命令
   ```  
   npm install -g @vue/cli
   
   
   npm install -g @vue/cli@4.5.9
   
   
   vue create web
   
 
   npm install ant-design-vue@next --save
   
  
   npm install ant-design-vue@2.0.0-rc.3 --save
   
   npm install axios@0.21.0 --save

```
## sql语句
```
drop TABLE if exists `ebook`;
create TABLE `ebook` (

	`id` BIGINT NOT NULL COMMENT 'id',
	`name` VARCHAR(50)  COMMENT '名称',
	`category1_id` BIGINT  COMMENT '分类1',
	`category2_id` BIGINT  COMMENT '分类2',
	`description` VARCHAR(200) COMMENT '描述',
	`cover` VARCHAR(200) COMMENT '封面',
	`doc_count` int COMMENT '文档量',
	`view_count` int COMMENT '阅读数',
	`vote_count` int COMMENT '点赞数',
	PRIMARY KEY (`id`)
)ENGINE = INNODB default charset=utf8mb4 COMMENT = '电子书';

insert INTO `ebook` (id,name,description) values (1,'springboot','零基础入门java') ;
insert INTO `ebook` (id,name,description) values (2,'天官赐福','百无禁忌') ;
```
分类
```
    创建分类数据库
    create table `category`(
   `id` bigint not null comment 'id',
   `parent` bigint not null DEFAULT 0 comment '父id',
   `name` varchar(50) not null  COMMENT '名称',
   `sort` int COMMENT '顺序'
   ) ENGINE = innodb DEFAULT charset=utf8mb4 COMMENT='分类'
   插入数据
   insert into `category` (id,parent,name,sort) VALUES (100,000,'前端开发',100);
   insert into `category` (id,parent,name,sort) VALUES (101,100,'Vue',101);
   insert into `category` (id,parent,name,sort) VALUES (102,100,'Html',102);
   insert into `category` (id,parent,name,sort) VALUES (200,000,'java',100);
   insert into `category` (id,parent,name,sort) VALUES (201,200,'java面向对象',201);
   insert into `category` (id,parent,name,sort) VALUES (202,200,'spring框架',202);
   insert into `category` (id,parent,name,sort) VALUES (300,000,'python',300);
   insert into `category` (id,parent,name,sort) VALUES (301,300,'python基础应用',301);
   insert into `category` (id,parent,name,sort) VALUES (302,300,'python高级开发',302);
   insert into `category` (id,parent,name,sort) VALUES (400,000,'数据库',400);
   insert into `category` (id,parent,name,sort) VALUES (401,400,'mysql',401);
   insert into `category` (id,parent,name,sort) VALUES (402,400,'redis',402);

 ```