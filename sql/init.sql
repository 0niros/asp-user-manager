CREATE DATABASE IF NOT EXISTS `asp`;
USE `asp`;

CREATE TABLE `role_info`(
                            `id` BIGINT (20) UNIQUE NOT NULL AUTO_INCREMENT COMMENT 'id',
                            `role_name` VARCHAR (64) UNIQUE NOT NULL DEFAULT '' COMMENT 'roleName',
                            INDEX(`role_name`),
                            PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'role_info';
insert into `role_info` values (1, 'admin');
insert into `role_info` values (2, 'user');

CREATE TABLE `user_info`(
                          `id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT 'id',
                          `username` VARCHAR (64) UNIQUE NOT NULL DEFAULT '' COMMENT 'username',
                          `password` VARCHAR (256) NOT NULL DEFAULT '' COMMENT 'password',
                          `role_id` BIGINT (20) NOT NULL DEFAULT 1 COMMENT 'roleId',
                          `avatar_path` TEXT NOT NULL COMMENT 'avatarPath',
                          INDEX(`username`),
                          INDEX(`role_id`),
                          PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'user_info';
insert into `user_info` values (1, 'admin', 'admin', 0, '');