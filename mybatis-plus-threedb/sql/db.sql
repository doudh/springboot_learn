create table db1.user
(
    id bigint  comment '主键' primary key,
    age int null comment '年龄',
    password varchar(32) null comment '密码',
    sex int null comment '性别',
    username varchar(32) null comment '用户名'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';

INSERT INTO db1.user (id, age, password, sex, username) VALUES (1, 22, 'admin', 1, 'admin');

create table db2.user
(
    id bigint  comment '主键' primary key,
    age int null comment '年龄',
    password varchar(32) null comment '密码',
    sex int null comment '性别',
    username varchar(32) null comment '用户名'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';

INSERT INTO db2.user (id, age, password, sex, username) VALUES (2, 22, 'admin', 1, 'admin');

create table db3.user
(
    id bigint  comment '主键' primary key,
    age int null comment '年龄',
    password varchar(32) null comment '密码',
    sex int null comment '性别',
    username varchar(32) null comment '用户名'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';
INSERT INTO db3.user (id, age, password, sex, username) VALUES (3, 19, 'uuu', 2, 'user');
INSERT INTO db3.user (id, age, password, sex, username) VALUES (4, 18, 'bbbb', 1, 'zzzz');