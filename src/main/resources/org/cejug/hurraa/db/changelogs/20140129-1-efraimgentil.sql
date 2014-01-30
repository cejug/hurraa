--liquibase formatted sql

--changeset efraimgentil:4
ALTER TABLE Sector ADD email VARCHAR(255) not null;
ALTER TABLE Sector ADD active BOOLEAN not null default 1;
ALTER TABLE Sector ADD respondsOccurrence BOOLEAN not null default 1;