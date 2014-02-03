--liquibase formatted sql

--changeset brunnogoncalves:6
create table EquipmentType (
    id          integer      not null primary key auto_increment,
    name        varchar(100) not null
) engine = innodb;