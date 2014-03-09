--liquibase formatted sql

--changeset diogodias86:10
create table ProblemType (
    id          integer      not null primary key auto_increment,
    name        varchar(100) not null unique
) engine = innodb;