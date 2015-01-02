drop table if exists ss_user;
drop table if exists product;
drop table if exists dest;
drop table if exists product_has_dest;
drop table if exists tag_group;
drop table if exists tag;
drop table if exists product_has_tag;
drop table if exists product_desc;
drop table if exists merchant;
drop table if exists ad_position;
drop table if exists ad_content;

create table ss_user (
	id bigint auto_increment,
	login_name varchar(64) not null unique,
	name varchar(64) not null,
	password varchar(255) not null,
	salt varchar(64) not null,
	roles varchar(255) not null,
	
	merchant_id bigint,
	creater bigint,
	create_time timestamp,
	primary key (id)
);


CREATE TABLE product_desc (
  id bigint  generated by default as identity,
  content TEXT NULL,
  product_id BIGINT NOT NULL,
  desc_index BIGINT NULL COMMENT '排序号',
  type BIGINT NULL COMMENT '0：desc  1:image',
  	creater bigint,
	create_time timestamp,
  PRIMARY KEY (id)
);






create table product_has_tag (
  product_id BIGINT NOT NULL,
  tag_id BIGINT NOT NULL,
  id bigint generated by default as identity,
  PRIMARY KEY (id)
);

create table tag (
  id bigint generated by default as identity,
  name VARCHAR(300) NULL COMMENT 'tag名',
  group_id bigint NOT NULL,
  	creater bigint,
	create_time timestamp,
  PRIMARY KEY (id),
);


create table tag_group (
  id bigint generated by default as identity,
  name VARCHAR(300) NULL comment 'tag组名',
  	creater bigint,
	create_time timestamp,
  PRIMARY KEY (id)
);


create table product_has_dest (
  product_id BIGINT NOT NULL,
  dest_id BIGINT NOT NULL,
  id bigint generated by default as identity, 
  PRIMARY KEY (id)
);

create table dest (
 id bigint generated by default as identity,
  name VARCHAR(200)  ,
  type bigint,
  pic varchar(1000),
  	creater bigint,
	create_time timestamp,
  PRIMARY KEY (id)
 );

create table product (
  id bigint generated by default as identity,
  name varchar(200),
  category_id bigint ,
  recommand varchar(500) ,
  status bigint  ,
  price DECIMAL(10,2)  ,
  merchant_id bigint ,
  url varchar(2000)  ,
  stock DECIMAL(10,0) ,
  pics text,
  	creater bigint,
	create_time timestamp,
  primary key (id)
 );
 
 create table merchant (
  id bigint generated by default as identity,
  name VARCHAR(500) NULL,
  type bigint NULL,
  owner bigint NULL,
  	creater bigint,
	create_time timestamp,
  PRIMARY KEY (id)
);


CREATE TABLE  ad_position (
  id bigint generated by default as identity,
  code VARCHAR(100) NULL,
  name VARCHAR(500) NULL,
  pageId bigint,
  creater bigint,
  create_time timestamp,
  PRIMARY KEY (id));
  
CREATE TABLE ad_content (
   id bigint generated by default as identity,
  url VARCHAR(500) NULL,
  pic VARCHAR(500) NULL,
  text VARCHAR(500) NULL,
  exts VARCHAR(1000) NULL,
  ad_index INT NULL,
  ad_position_id INT NOT NULL,
  creater bigint,
  create_time timestamp,
  PRIMARY KEY (id)
 );
