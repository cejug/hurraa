--liquibase formatted sql

--changeset efraimgentil:7
create table EquipmentModel (
    id          integer      not null primary key auto_increment,
    name        varchar(100) not null unique,
    equipmentType_id          integer      not null ,
    FOREIGN KEY (equipmentType_id) REFERENCES EquipmentType(id)
) engine = innodb;