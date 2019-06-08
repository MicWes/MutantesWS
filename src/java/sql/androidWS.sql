create table usuario(
	user_id serial primary key,
	login varchar(30),
	password varchar(50)
);

create table habilidade(
	hability_id serial primary key,
	description varchar(100)
);

create table mutante(
	mutante_id serial primary key,
	nome varchar(50),
	user_id int,
	hability_id int,
	constraint mut_usu_fk foreign key (user_id) references usuario(user_id),
	constraint mut_hab_fk foreign key (hability_id) references habilidade(hability_id)
);

alter table mutante
add column image bytea
 