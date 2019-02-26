drop table if exists sys_logininfor;

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
