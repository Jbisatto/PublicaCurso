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
    
select * from marcas;
select * from tipos;
select * from produtos;

select 
	produtos.codigo,
    produtos.nome,
    produtos.valor,
    marcas.nome,
    tipos.nome
from produtos 
inner join marcas
on  produtos.marca = marcas.codigo
inner join tipos
on  produtos.tipo = tipos.codigo
where tipos.nome like "%tv%"
order by produtos.codigo;

insert into marcas (nome) values 
("Apple"),
("Xiaomi"),
("Panasonic"),
("Samsung"),
("LG");
