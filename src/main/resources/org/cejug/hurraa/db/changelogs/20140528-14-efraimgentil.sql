--liquibase formatted sql

--changeset efraimgentil:14 failOnError:true
ALTER TABLE Occurrence ADD occurrenceState_id integer;
ALTER TABLE Occurrence ADD FOREIGN KEY (occurrenceState_id) REFERENCES OccurrenceState(id); 
ALTER TABLE Occurrence DROP COLUMN status;

