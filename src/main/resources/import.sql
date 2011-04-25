insert into credential (id, banned, rank, login, password, role) values (1, false, 0, 'nauczyciel1', 'a', 2);
insert into credential (id, banned, rank, login, password, role) values (2, false, 0, 'nauczyciel2', 'a', 2);
insert into credential (id, banned, rank, login, password, role) values (3, false, 0, 'admin1', 'a', 1);
insert into credential (id, banned, rank, login, password, role) values (4, false, 0, 'user1', 'a', 0);
insert into credential (id, banned, rank, login, password, role) values (5, false, 0, 'user2', 'a', 0);

insert into user (id, name, surname, credential_id) values (1, 'Jan', 'Kowalski', 1);
insert into user (id, name, surname, credential_id) values (2, 'Imiê2', 'Nazwisko2', 2);
insert into user (id, name, surname, credential_id) values (3, 'Imiê3', 'Nazwisko3', 3);
insert into user (id, name, surname, credential_id) values (4, 'Imiê4', 'Nazwisko4', 4);
insert into user (id, name, surname, credential_id) values (5, 'Imiê5', 'Nazwisko5', 5);

insert into lecture values (1, 'Opis 1', 'Wyklad 1');
insert into lecture values (2, 'Opis 2', 'Wyklad 2');
insert into lecture values (3, 'Opis 3', 'Wyklad 3');

insert into lecturedetail(id, rate, lecture_id, teacher_id, limit, startdate) values (1, 6, 1, 1, 30, '2011-04-20 10:00');
insert into lecturedetail(id, rate, lecture_id, teacher_id, limit, startdate) values (2, 6, 2, 2, 20, '2011-04-25 11:00');
insert into lecturedetail(id, rate, lecture_id, teacher_id, limit, startdate) values (3, 6, 3, 2, 10, '2011-04-30 09:45');
insert into lecturedetail(id, rate, lecture_id, teacher_id, limit, startdate) values (4, 6, 1, 1, 25, '2011-05-05 10:15');