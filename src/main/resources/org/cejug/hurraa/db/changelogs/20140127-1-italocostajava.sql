--liquibase formatted sql

--changeset italocostajava:2
create table Manufacturer (
    id          integer      not null primary key auto_increment,
    name        varchar(100) not null
) engine = innodb;