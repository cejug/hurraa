--liquibase formatted sql

--changeset emanuelcordeiro:8
create table Equipment (
    id               integer      not null primary key auto_increment,
    serial_id        varchar(100) not null unique,
    end_of_warranty  datetime not null,
    last_maintenance datetime,
    maintenance_description varchar(100),
    equipmentModel_id integer not null,
    FOREIGN KEY (equipmentModel_id) REFERENCES EquipmentModel(id)
) engine = innodb;
