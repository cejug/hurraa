--liquibase formatted sql

--changeset efraimgentil:8
ALTER TABLE EquipmentType MODIFY name varchar(100) NOT NULL UNIQUE;