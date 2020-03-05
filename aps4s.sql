create database ProjetoTamar;
use ProjetoTamar;

create table tartarugas(
id int(11) primary key,
Especie varchar(155),
Nome_popular varchar(155),
Tipo_de_localizador varchar(155),
Risco_de_Extincao varchar(30));


# Testes ///////////////////////////////////////////////////////////////////////////////
insert into tartarugas values (1, "Marinhes Aquatics", "Tartaruga Azul", "GPS", "Médio");
insert into tartarugas values (2, "Marinhes Voadoris", "Tartaruga Azul", "GPS", "Médio");
insert into tartarugas values (3, "Azul seila", "Tartaruga Azul", "GPS", "Médio");
insert into tartarugas values (4, "Erickson Elfelics", "Erick", "Satélite", "Alto");
insert into tartarugas values (5, "Juhliao friendzone", "Juh", "Friendzone", "Alto");
insert into tartarugas values (6, "Farm farm", "farm", "Satélite", "Médio");
insert into tartarugas values (7, "Marin Tockhry", "Tartaruga rosa", "Satélite", "Baixo");
insert into tartarugas values (8, "Grenz Tockty", "Tartaruga verde", "GPS", "Baixo");
insert into tartarugas values (9, "Pink Turtle ", "Tartaruga Azul", "GPS", "Alto");
insert into tartarugas values (10, "Marinhes salt ", "Tartaruga do mar", "GPS", "Médio");
insert into tartarugas values (11, "Marinhes ", "Tartaruga Azul", "GPS", "Médio");
insert into tartarugas values (12, "Marinhes ", "Tartaruga Azul", "GPS", "Médio");
insert into tartarugas values (13, "Marinhes ", "Tartaruga Azul", "GPS", "Médio");
insert into tartarugas values (14, "Marinhes ", "Tartaruga Azul", "GPS", "Médio");
select * from tartarugas;
