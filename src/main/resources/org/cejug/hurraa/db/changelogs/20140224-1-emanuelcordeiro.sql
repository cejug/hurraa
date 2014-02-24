--liquibase formatted sql

--changeset emanuelcordeiro:9
alter table Equipment modify last_maintenance datetime;
