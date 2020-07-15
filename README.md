

## 테이블 생성 및 데이터 입력 (MySQL)

````sql
create user 'spring'@'%' identified by 'bitc5600';
GRANT ALL PRIVILEGES ON *.* TO 'spring'@'%';
create database spring;
use spring;

CREATE TABLE member(
	id int auto_increment primary key,
    username varchar(100) unique not null,
    phone varchar(100)
) engine=InnoDB default charset=utf8;

insert into member(username,phone) values("ssar","01022223333");
insert into member(username,phone) values("ssarmango","01099998888");
insert into member(username,phone) values("kim","01055556666");
````

## mybatis-spring-boot
https://mybatis.org/spring-boot-starter/