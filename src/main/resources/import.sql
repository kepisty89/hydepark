insert into credential (id, banned, rank, login, password, role) values (1, false, 0, 'n1', 'a', 2);
insert into credential (id, banned, rank, login, password, role) values (2, false, 0, 'n2', 'a', 2);
insert into credential (id, banned, rank, login, password, role) values (3, false, 0, 'landus1', 'a', 0);
insert into credential (id, banned, rank, login, password, role) values (4, false, 0, 'landus2', 'a', 0);
insert into credential (id, banned, rank, login, password, role) values (5, false, 0, 'landus3', 'a', 0);

insert into user (id, name, surname, credential_id) values (1, 'Nauczyciel1', '1', 1);
insert into user (id, name, surname, credential_id) values (2, 'Nauczyciel2', '2', 2);
insert into user (id, name, surname, credential_id) values (3, 'Daniel1', 'Landowski1', 3);
insert into user (id, name, surname, credential_id) values (4, 'Daniel2', 'Landowski2', 4);
insert into user (id, name, surname, credential_id) values (5, 'Daniel3', 'Landowski3', 5);

insert into lecture values (1, 'Opis 1', 'Wyklad 1');
insert into lecture values (2, 'Opis 2', 'Wyklad 2');
insert into lecture values (3, 'Opis 3', 'Wyklad 3');

insert into lecturedetail(id, rate, lecture_id, teacher_id) values (1, 6, 1, 1);
insert into lecturedetail(id, rate, lecture_id, teacher_id) values (2, 6, 1, 1);
insert into lecturedetail(id, rate, lecture_id, teacher_id) values (3, 6, 1, 1);
insert into lecturedetail(id, rate, lecture_id, teacher_id) values (4, 6, 1, 1);