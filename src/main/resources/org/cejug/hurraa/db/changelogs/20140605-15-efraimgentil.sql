--liquibase formatted sql

--changeset efraimgentil:15 failOnError:true
create table OccurrenceUpdate (
    id             bigint       not null primary key auto_increment,
    updateNote     TEXT,
    updateDate     datetime     not null,
    user_id        integer,
    occurrence_id  bigint       not null,
    active         boolean      not null default 1
) engine = innodb;
--rollback drop table OccurrenceUpdate;

create table OccurrenceFieldUpdate (
    occurrenceUpdate_id         bigint,
    fieldName      varchar(255) not null,
    newValue       varchar(255) not null,
    oldValue       varchar(255) not null,
    PRIMARY KEY (occurrenceUpdate_id),
    FOREIGN KEY (occurrenceUpdate_id) REFERENCES OccurrenceUpdate(id)
) engine = innodb;
--rollback drop table OccurrenceUpdate;


