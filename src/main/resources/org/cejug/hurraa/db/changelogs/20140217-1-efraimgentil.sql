--liquibase formatted sql

--changeset efraimgentil:10
ALTER TABLE Sector MODIFY name varchar(100) NOT NULL UNIQUE;