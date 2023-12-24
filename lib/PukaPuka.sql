drop database PukaPuka;
create schema if not exists pukapuka;
use pukapuka;

create table if not exists vendedor(
    idvend int not null auto_increment,
    nome varchar(60) not null,
    cpf varchar(12),
    turno varchar(20),
    primary key(idvend)
);

create table if not exists comprador(
    idcom int not null auto_increment,
    nome varchar(60) not null,
    cpf varchar(12),
    credito float,
    primary key(idcom)
);

create table if not exists livro(
    idlivro int not null auto_increment,
    titulo varchar(45),
    autor varchar(60),
    preco float,
    primary key(idlivro)
);

create table if not exists venda(
    idvenda int not null auto_increment,
    data date,
    idcom int,
    idlivro int,
    idvend int,
    primary key(idvenda),

    foreign key (idcom) 
    references comprador (idcom),

    foreign key(idlivro)
    references livro (idlivro),

    foreign key(idvend)
    references vendedor (idvend)
);