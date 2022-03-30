create database projetoBdJefferson;

use projetoBdJefferson;

create table marcas(
	codigo int primary key auto_increment,
    nome varchar(20)						
);
create table tipos(
	codigo int primary key auto_increment,
    nome varchar(20)						
);

create table produtos(
	codigo int auto_increment primary key,
    nome varchar(30),
    valor double,
    marca int,
    tipo int,
    foreign key (marca) references marcas(codigo),
    foreign key (tipo) references tipos(codigo));
