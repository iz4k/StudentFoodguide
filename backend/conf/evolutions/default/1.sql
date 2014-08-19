# --- Database scheme

# --- !Ups

CREATE TABLE Restaurant (
	id				bigint not null PRIMARY KEY AUTO_INCREMENT,
	name			varchar(512) not null,
	address			varchar(512) not null,
	city			varchar(512) not null,
	postal_code		int not null,
	opening_hours	varchar(512) not null
);

CREATE TABLE Menu (
	id				bigint not null PRIMARY KEY AUTO_INCREMENT,
	day				date not null,
	restaurant_id	bigint not null REFERENCES restaurant(id)
);

CREATE TABLE Food (
	id				bigint not null PRIMARY KEY AUTO_INCREMENT,
	name			varchar(512),
	price			numeric,
	additional_info	varchar(512)
);

CREATE TABLE School (
	id				bigint not null PRIMARY KEY AUTO_INCREMENT,
	name			varchar(512)
);

CREATE TABLE Menu_Food (
	id				bigint not null PRIMARY KEY AUTO_INCREMENT,
	menu_id			bigint not null REFERENCES menu(id),
	food_id			bigint not null REFERENCES food(id)
);