#mp_user表
CREATE TABLE `mp_user`(
	`id` BIGINT(20) NOT NULL COMMENT '主键ID',
	`name` VARCHAR(30) NOT NULL DEFAULT '' COMMENT '姓名',
	`age` INT(11) NOT NULL DEFAULT 0 COMMENT '年龄',
	`email` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '邮箱',
	`created_time` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '创建时间',
	`updated_time` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '更新时间',
	`deleted` TINYINT(3) NOT NULL DEFAULT 0 COMMENT '状态:0-正常,1-删除',
	`version` BIGINT(20) NOT NULL DEFAULT 1 COMMENT '乐观锁版本控制',
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';
INSERT INTO `mp_user` (`id`, `name`, `age`, `email`) VALUES
(1, 'Jone', 18, 'test1@baomidou.com'),
(2, 'Jack', 20, 'test2@baomidou.com'),
(3, 'Tom', 28, 'test3@baomidou.com'),
(4, 'Sandy', 21, 'test4@baomidou.com'),
(5, 'Billie', 24, 'test5@baomidou.com');


#mp_article表
CREATE TABLE `mp_article`(
	`id` BIGINT(20) NOT NULL COMMENT '主键ID',
	`title` VARCHAR(30) NOT NULL DEFAULT '' COMMENT '标题',
	`content` INT(11) NOT NULL DEFAULT 0 COMMENT '内容',
	`created_time` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '创建时间',
	`updated_time` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '更新时间',
	`deleted_time` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '删除时间',
	`status` TINYINT(3) NOT NULL DEFAULT 0 COMMENT '状态:0-正常,1-删除',
	`version` BIGINT(20) NOT NULL DEFAULT 1 COMMENT '乐观锁版本控制',
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章';
INSERT INTO `mp_article` (`id`, `title`, `content`) VALUES
(1, 'java学习', 'mybatis教程'),
(2, 'python学习', '爬虫教程');