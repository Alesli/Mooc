-- Отключение внешних ключей
-- 
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

SET NAMES 'utf8';

DROP DATABASE IF EXISTS mooc;

CREATE DATABASE IF NOT EXISTS mooc
CHARACTER SET utf8
COLLATE utf8_general_ci;

USE mooc;

CREATE TABLE IF NOT EXISTS course (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  description varchar(255) DEFAULT NULL,
  language varchar(50) DEFAULT NULL,
  diration_hours int(11) DEFAULT NULL,
  PRIMARY KEY (id)
)
CHARACTER SET utf8,
COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS unit (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  course_id bigint(20) NOT NULL,
  name varbinary(50) NOT NULL,
  description varchar(255) DEFAULT NULL,
  diration_hours int(11) DEFAULT NULL,
  PRIMARY KEY (id)
)
CHARACTER SET utf8,
COLLATE utf8_general_ci;

ALTER TABLE unit
ADD CONSTRAINT FK_unit_course_id FOREIGN KEY (course_id)
REFERENCES course (id);

CREATE TABLE IF NOT EXISTS lesson (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  unit_id bigint(20) NOT NULL,
  name varchar(50) NOT NULL,
  description varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
)
CHARACTER SET utf8,
COLLATE utf8_general_ci;

ALTER TABLE lesson
ADD CONSTRAINT FK_lesson_unit FOREIGN KEY (unit_id)
REFERENCES unit (id);

CREATE TABLE IF NOT EXISTS lesson_item (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  lesson_id bigint(20) NOT NULL,
  name varchar(50) NOT NULL,
  description mediumtext DEFAULT NULL,
  PRIMARY KEY (id)
)
CHARACTER SET utf8,
COLLATE utf8_general_ci;

ALTER TABLE lesson_item
ADD CONSTRAINT FK_item_lesson_id FOREIGN KEY (lesson_id)
REFERENCES lesson (id);

CREATE TABLE IF NOT EXISTS user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  full_name varchar(50) NOT NULL,
  password varchar(50) NOT NULL,
  login varchar(50) NOT NULL,
  role varchar(15) NOT NULL,
  PRIMARY KEY (id)
)
CHARACTER SET utf8,
COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS user_lesson_item (
  user_id bigint(20) NOT NULL,
  lesson_item_id bigint(20) NOT NULL
)
CHARACTER SET utf8,
COLLATE utf8_general_ci;

ALTER TABLE user_lesson_item
ADD UNIQUE INDEX user_lesson_unique (lesson_item_id, user_id);

ALTER TABLE user_lesson_item
ADD CONSTRAINT FK_lesson_item_id FOREIGN KEY (lesson_item_id)
REFERENCES lesson (id);

ALTER TABLE user_lesson_item
ADD CONSTRAINT FK_user_id FOREIGN KEY (user_id)
REFERENCES user (id);

CREATE TABLE IF NOT EXISTS user_course (
  user_id bigint(20) NOT NULL,
  course_id bigint(20) NOT NULL
)
CHARACTER SET utf8,
COLLATE utf8_general_ci;

ALTER TABLE user_course
ADD UNIQUE INDEX user_course_unique (course_id, user_id);

ALTER TABLE user_course
ADD CONSTRAINT FK_course_progress_id FOREIGN KEY (course_id)
REFERENCES course (id);

ALTER TABLE user_course
ADD CONSTRAINT FK_user_progress_id FOREIGN KEY (user_id)
REFERENCES user (id);

-- Восстановить предыдущий режим SQL (SQL mode)
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;

-- Включение внешних ключей
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;