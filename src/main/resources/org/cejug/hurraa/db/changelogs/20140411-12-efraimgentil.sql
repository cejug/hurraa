--liquibase formatted sql

--changeset efraimgentil:12
ALTER TABLE Occurrence CHANGE dateOfOppening dateOfOpening datetime;
