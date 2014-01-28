--liquibase formatted sql

--changeset paulojribp:1
create table User (
    id          integer      not null primary key auto_increment,
    name        varchar(50)  not null,
    email       varchar(100) not null,
    password    varchar(100) not null
) engine = innodb;