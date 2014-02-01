--liquibase formatted sql

--changeset efraimgentil:5
create table CostCenter (
    id          bigint      not null primary key auto_increment,
    code        varchar(100) ,
    name        varchar(100) not null,
    description varchar(100)
) engine = innodb;