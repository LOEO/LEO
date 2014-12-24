CREATE DATABASE LEO DEFAULT CHAR SET = UTF8;
CREATE TABLE t_user(
  id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR (20)  NOT NULL ,
  password VARCHAR (20)  NOT NULL ,
  nickname VARCHAR (20)  NOT NULL ,
  age INT ,
  birthday DATE ,
  sex VARCHAR (4) ,
  avatar VARCHAR (50) ,
  email VARCHAR (30) ,
  phone VARCHAR (20)
)ENGINE=INNODB CHARSET=UTF8;

CREATE TABLE t_role(
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(20),
  descp VARCHAR(200)
)ENGINE=INNODB CHARSET=UTF8;

CREATE TABLE t_privilege(
  id INT PRIMARY KEY AUTO_INCREMENT,
  master VARCHAR(20),
  masterValue VARCHAR(20),
  access VARCHAR(20),
  accessValue VARCHAR(20),
  operation VARCHAR(20),
  createUserId INT,
  createDate DATETIME,
  modifyUserId INT,
  modifyDate DATETIME
)ENGINE=INNODB CHARSET=UTF8;

CREATE TABLE t_user_role(
  id INT PRIMARY KEY AUTO_INCREMENT,
  userId INT,
  roleId INT,
  CONSTRAINT FOREIGN KEY(userId) REFERENCES t_user(id),
  CONSTRAINT FOREIGN KEY (roleId) REFERENCES t_role(id)
)ENGINE=INNODB CHARSET=UTF8;

CREATE TABLE t_org(
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(20),
  pid INT,
  descp VARCHAR(200)
)ENGINE=INNODB CHARSET=UTF8;

CREATE TABLE t_user_org(
  id INT PRIMARY KEY AUTO_INCREMENT,
  userId INT,
  orgId INT,
  CONSTRAINT FOREIGN KEY (userId) REFERENCES t_user(id),
  CONSTRAINT FOREIGN KEY (orgId) REFERENCES t_org(id)
)ENGINE=INNODB CHARSET=UTF8;
