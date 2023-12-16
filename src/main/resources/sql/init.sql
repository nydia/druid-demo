drop table  if exists t_user;
create table t_user
(
    id   int(11) not null auto_increment,
    user_id   int(11) default null,
    name varchar(30) DEFAULT '',
    age  int(11) DEFAULT 0,
    PRIMARY KEY (`id`)
);

drop table  if exists t_order;
create table t_order
(
 id   int(11) not null auto_increment,
 order_no varchar(30) DEFAULT '',
 user_id  int(11) DEFAULT null,
 PRIMARY KEY (`id`)
);