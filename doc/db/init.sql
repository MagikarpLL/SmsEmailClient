create DATABASE IF NOT EXISTS d_gateway CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';

use d_gateway;

DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user (
id int(32) NOT NULL auto_increment,
account varchar(64) DEFAULT NULL,
password varchar(200) DEFAULT NULL,
name varchar(64) DEFAULT NULL,
mobile varchar(64) DEFAULT NULL,
email varchar(64) DEFAULT NULL,
created datetime DEFAULT now(),
updated datetime DEFAULT now(),
PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO d_gateway.t_user (account, password, name, mobile, email) VALUES ( 'lz', '123456', 'leizhen', '13006189736', '736478231@qq.com');
INSERT INTO d_gateway.t_user ( account, password, name, mobile, email) VALUES ( 'magi', '123456', 'magikarp', '13056788765', '13056788765@163.com');
