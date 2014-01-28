--liquibase formatted sql

--changeset efraimgentil:3
create table Sector (
    id          integer      not null primary key auto_increment,
    name        varchar(100) not null
) engine = innodb;