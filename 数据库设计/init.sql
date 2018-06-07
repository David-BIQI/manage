drop table if exists user;

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   int not null auto_increment,
   name                 varchar(100) not null,
   password             varchar(150) not null,
   phone                varchar(20),
   sex                  tinyint(1),
   created              datetime,
   createby             int,
   updated              datetime,
   updateby             int,
   primary key (id)
);
