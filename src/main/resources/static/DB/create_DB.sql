DROP SCHEMA IF EXISTS `calendue`;
CREATE SCHEMA `calendue`;
USE `calendue`;
DROP TABLE IF EXISTS `project`, `subproject`, `task`, `user`, `linkedtask`, `project_user`, `subproject_user`, `task_user`;
CREATE TABLE `calendue`.`project` (
                                      `project_id` INT NOT NULL AUTO_INCREMENT,
                                      `project_name` VARCHAR(255) NOT NULL,
                                      `project_description` VARCHAR(1000) NULL,
                                      `project_start` VARCHAR(255) NULL,
                                      `project_deadline` VARCHAR(255) NULL,
                                      `project_hours` INT NULL,
                                      `project_status` VARCHAR(255) NULL,
                                      PRIMARY KEY (`project_id`));

CREATE TABLE `calendue`.`subproject` (
                                         `subproject_id` INT NOT NULL AUTO_INCREMENT,
                                         `project_id` INT NOT NULL,
                                         `subproject_name` VARCHAR(255) NOT NULL,
                                         `subproject_description` VARCHAR(1000) NULL,
                                         `subproject_deadline` VARCHAR(255) NULL,
                                         `subproject_hours` INT NULL,
                                         `subproject_status` VARCHAR(255) NULL,
                                         PRIMARY KEY (`subproject_id`),
                                         INDEX `project_id_idx` (`project_id` ASC) VISIBLE,
                                         CONSTRAINT `project_fk_subproject`
                                             FOREIGN KEY (`project_id`)
                                                 REFERENCES `calendue`.`project` (`project_id`)
                                                 ON DELETE CASCADE
                                                 ON UPDATE NO ACTION);

CREATE TABLE `calendue`.`task` (
                                   `task_id` INT NOT NULL AUTO_INCREMENT,
                                   `subproject_id` INT NOT NULL,
                                   `task_name` VARCHAR(255) NOT NULL,
                                   `task_description` VARCHAR(1000) NULL,
                                   `task_comment` VARCHAR(1000) NULL,
                                   `task_deadline` VARCHAR(255) NULL,
                                   `task_hours` INT NULL,
                                   `task_priority` INT NULL,
                                   `task_status` VARCHAR(255) NULL,
                                   PRIMARY KEY (`task_id`),
                                   INDEX `subproject_id_idx` (`subproject_id` ASC) VISIBLE,
                                   CONSTRAINT `subproject_fk_task`
                                       FOREIGN KEY (`subproject_id`)
                                           REFERENCES `calendue`.`subproject` (`subproject_id`)
                                           ON DELETE CASCADE
                                           ON UPDATE NO ACTION);

CREATE TABLE `calendue`.`user` (
                                   `user_id` INT NOT NULL AUTO_INCREMENT,
                                   `username` VARCHAR(255) NOT NULL UNIQUE,
                                   `password` VARCHAR(60) NOT NULL,
                                   `email` VARCHAR(255) NOT NULL,
                                   `is_admin` INT NOT NULL,
                                   `full_name` VARCHAR(255) NOT NULL,
                                   PRIMARY KEY (`user_id`));

CREATE TABLE `calendue`.`linkedtask` (
                                         `linkedtask_id` INT NOT NULL,
                                         `task_id` INT NOT NULL,
                                         INDEX `task_id_idx` (`task_id` ASC) VISIBLE,
                                         CONSTRAINT `task_fk_linkedtask`
                                             FOREIGN KEY (`task_id`)
                                                 REFERENCES `calendue`.`task` (`task_id`)
                                                 ON DELETE CASCADE
                                                 ON UPDATE NO ACTION);

CREATE TABLE `calendue`.`project_user` (
                                           `project_id` INT NOT NULL,
                                           `user_id` INT NOT NULL,
                                           `role` VARCHAR(255) NOT NULL,
                                           INDEX `project_user_project_id_idx` (`project_id` ASC) VISIBLE,
                                           INDEX `project_user_user_id_idx` (`user_id` ASC) VISIBLE,
                                           CONSTRAINT `project_fk_project_user`
                                               FOREIGN KEY (`project_id`)
                                                   REFERENCES `calendue`.`project` (`project_id`)
                                                   ON DELETE CASCADE
                                                   ON UPDATE NO ACTION,
                                           CONSTRAINT `user_fk_project_user`
                                               FOREIGN KEY (`user_id`)
                                                   REFERENCES `calendue`.`user` (`user_id`)
                                                   ON DELETE CASCADE
                                                   ON UPDATE NO ACTION);


CREATE TABLE `calendue`.`task_user` (
                                        `task_id` INT NOT NULL,
                                        `user_id` INT NOT NULL,
                                        INDEX `task_user_task_id_idx` (`task_id` ASC) VISIBLE,
                                        INDEX `task_user_user_id_idx` (`user_id` ASC) VISIBLE,
                                        CONSTRAINT `task_fk_task_user`
                                            FOREIGN KEY (`task_id`)
                                                REFERENCES `calendue`.`task` (`task_id`)
                                                ON DELETE CASCADE
                                                ON UPDATE NO ACTION,
                                        CONSTRAINT `user_fk_task_user`
                                            FOREIGN KEY (`user_id`)
                                                REFERENCES `calendue`.`user` (`user_id`)
                                                ON DELETE CASCADE
                                                ON UPDATE NO ACTION);