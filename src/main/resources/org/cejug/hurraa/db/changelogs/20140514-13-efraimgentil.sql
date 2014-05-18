--liquibase formatted sql

--changeset efraimgentil:13 failOnError:true
create table OccurrenceState (
    id          integer      not null primary key auto_increment,
    name        varchar(100) not null unique,
    active      boolean      not null default 1
) engine = innodb;
--rollback drop table OccurrenceState;

insert into OccurrenceState ( name ) VALUES("Novo");
--rollback drop table OccurrenceState;
insert into OccurrenceState ( name ) VALUES("Em Atendimento");
--rollback drop table OccurrenceState;
insert into OccurrenceState ( name ) VALUES("Rejeitado");
--rollback drop table OccurrenceState;
insert into OccurrenceState ( name ) VALUES("Solucionado");
--rollback drop table OccurrenceState;
insert into OccurrenceState ( name ) VALUES("Em Análise");
--rollback drop table OccurrenceState;
