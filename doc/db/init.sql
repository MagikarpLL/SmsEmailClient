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

DROP TABLE IF EXISTS `t_image_code`;
CREATE TABLE `t_image_code`(
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增长主键',
    `receiver` varchar(50) NOT NULL COMMENT '接受者账号/手机号/邮箱号',
    `distance` int(11) NOT NULL COMMENT '滑动距离',
    `is_checked` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否被使用，0没有1有',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `expire_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
    PRIMARY KEY (`id`),
    KEY `index_t_image_code_receiver` (`receiver`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图片验证码表';