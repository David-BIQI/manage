



drop table if exists permission;

drop table if exists role;

drop table if exists role_to_permission;

drop table if exists user_to_role;

/*==============================================================*/
/* Table: permission                                            */
/*==============================================================*/
create table permission
(
   id                   int not null auto_increment,
   name                 varchar(50) comment '权限名称',
   url                  varchar(100) not null comment '请求路径',
   permission           varchar(150) not null comment '角色编码',
   status               tinyint(1) default 1,
   created              datetime default CURRENT_TIMESTAMP,
   createdby            int,
   updated              datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   updatedby            int default 0,
   remark               varchar(50) default '',
   primary key (id)
);

alter table permission comment '权限表';

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role
(
   id                   int not null auto_increment,
   role_name            varchar(100) not null comment '角色名称',
   role_code            varchar(150) not null comment '角色编码',
   status               tinyint(1) default 1,
   created              datetime default CURRENT_TIMESTAMP,
   createdby            int,
   updated              datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   updatedby            int,
   remark               varchar(50) default '',
   primary key (id)
);

alter table role comment '角色表';

/*==============================================================*/
/* Table: role_to_permission                                    */
/*==============================================================*/
create table role_to_permission
(
   id                   int not null auto_increment,
   permission_id        varchar(100) not null comment '权限id',
   role_id              varchar(150) not null comment '角色id',
   status               tinyint(1) default 1,
   created              datetime default CURRENT_TIMESTAMP,
   createdby            int,
   updated              datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   updatedby            int,
   primary key (id)
);

alter table role_to_permission comment '角色与权限表';

/*==============================================================*/
/* Table: user_to_role                                          */
/*==============================================================*/
create table user_to_role
(
   id                   int not null auto_increment,
   user_id              varchar(100) not null,
   role_id              varchar(150) not null,
   status               tinyint(1) default 1,
   created              datetime default CURRENT_TIMESTAMP,
   createdby            int,
   updated              datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   updatedby            int,
   primary key (id)
);

alter table user_to_role comment '用户角色表';

