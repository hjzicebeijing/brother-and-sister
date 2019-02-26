/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019-2-22 12:10:29                           */
/*==============================================================*/


drop table if exists service_food;

drop table if exists service_order;

drop table if exists service_pay;

drop table if exists sys_logininfor;

drop table if exists sys_role;

drop table if exists sys_seller;

drop table if exists sys_seller_type;

drop table if exists sys_user;

drop table if exists sys_user_role_r;

/*==============================================================*/
/* Table: service_food                                          */
/*==============================================================*/
create table service_food
(
   food_id              int not null auto_increment,
   seller_name          varchar(50),
   food_name            varchar(20),
   food_img             varchar(200),
   food_price           varchar(50),
   food_status          int,
   primary key (food_id)
);

/*==============================================================*/
/* Table: service_order                                         */
/*==============================================================*/
create table service_order
(
   order_id             int not null auto_increment,
   seller_id            int,
   food_id              int,
   user_id              int,
   method               varchar(20),
   status               int,
   total                varchar(50),
   primary key (order_id)
);

/*==============================================================*/
/* Table: service_pay                                           */
/*==============================================================*/
create table service_pay
(
   pay_id               int not null auto_increment,
   seller_id            int,
   user_id              int,
   order_id             int,
   pay_time             timestamp default CURRENT_TIMESTAMP,
   status               int,
   primary key (pay_id)
);

/*==============================================================*/
/* Table: sys_logininfor                                        */
/*==============================================================*/
create table sys_logininfor
(
   logger_id            int not null auto_increment,
   login_name           varchar(30),
   ipaddr               varchar(50),
   browser              varchar(50),
   os                   varchar(50),
   login_result         varchar(20),
   login_message        varchar(50),
   login_time           timestamp default CURRENT_TIMESTAMP,
   primary key (logger_id)
);

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
create table sys_role
(
   role_id              int not null auto_increment,
   role_name            varchar(50),
   role_creator         varchar(100),
   site_id              varchar(100),
   primary key (role_id)
);

/*==============================================================*/
/* Table: sys_seller                                            */
/*==============================================================*/
create table sys_seller
(
   seller_id            int not null auto_increment,
   login_name           varchar(30),
   seller_name          varchar(50),
   seller_flag          varchar(100),
   seller_desc          varchar(500),
   seller_status        varchar(20),
   seller_connect       varchar(20),
   seller_score         varchar(10),
   seller_typename      varchar(50),
   seller_addr          varchar(500),
   primary key (seller_id)
);

/*==============================================================*/
/* Table: sys_seller_type                                       */
/*==============================================================*/
create table sys_seller_type
(
   sellerType_id        int not null auto_increment,
   sellerType_name      varchar(50),
   sellerType_score     varchar(10),
   primary key (sellerType_id)
);

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
create table sys_user
(
   user_id              int not null auto_increment,
   login_name           varchar(30),
   user_name            varchar(30),
   phonenumber          varchar(20),
   email                varchar(100),
   password             varchar(100),
   salt                 varchar(100),
   status               int,
   refuse_des           varchar(500),
   headportrait         varchar(100),
   primary key (user_id)
);

/*==============================================================*/
/* Table: sys_user_role_r                                       */
/*==============================================================*/
create table sys_user_role_r
(
   r_id                 int not null auto_increment,
   user_id              int,
   role_id              int,
   primary key (r_id)
);

