--liquibase formatted sql

--changeset efraimgentil:11
create table Occurrence (
    id          bigint not null primary key auto_increment,
    serialId    varchar(100) ,
    description text not null,
    status      varchar(100),
    dateOfOppening datetime,
    problemType_id integer not null,
    sector_id   integer not null,
    user_id     integer not null,
    FOREIGN KEY (problemType_id) REFERENCES ProblemType(id),
    FOREIGN KEY (sector_id) REFERENCES Sector(id),
    FOREIGN KEY (user_id) REFERENCES User(id)
) engine = innodb;