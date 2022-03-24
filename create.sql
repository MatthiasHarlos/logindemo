create table authorities (username varchar(255) not null, authority varchar(255), primary key (username));
create table users (username varchar(255) not null, enabled boolean not null, password varchar(255), authority_username varchar(255), primary key (username));
alter table users add constraint FKgyqmryniy5ww2ajbsj7y71c9l foreign key (authority_username) references authorities;
create table authorities (username varchar(255) not null, authority varchar(255), primary key (username));
create table users (username varchar(255) not null, enabled boolean not null, password varchar(255), authority_username varchar(255), primary key (username));
alter table users add constraint FKgyqmryniy5ww2ajbsj7y71c9l foreign key (authority_username) references authorities;
