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