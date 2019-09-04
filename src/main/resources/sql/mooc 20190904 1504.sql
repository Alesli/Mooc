--
-- Скрипт сгенерирован Devart dbForge Studio for MySQL, Версия 8.0.80.0
-- Домашняя страница продукта: http://www.devart.com/ru/dbforge/mysql/studio
-- Дата скрипта: 04.09.2019 15:04:54
-- Версия сервера: 5.7.25-log
-- Версия клиента: 4.1
--

-- 
-- Отключение внешних ключей
-- 
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;

-- 
-- Установить режим SQL (SQL mode)
-- 
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 
-- Установка кодировки, с использованием которой клиент будет посылать запросы на сервер
--
SET NAMES 'utf8';

DROP DATABASE IF EXISTS mooc;

CREATE DATABASE IF NOT EXISTS mooc
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Установка базы данных по умолчанию
--
USE mooc;

--
-- Создать таблицу `course`
--
CREATE TABLE IF NOT EXISTS course (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  description varchar(255) DEFAULT NULL,
  language varchar(50) DEFAULT NULL,
  diration_hours int(11) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

--
-- Создать таблицу `unit`
--
CREATE TABLE IF NOT EXISTS unit (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  course_id bigint(20) NOT NULL,
  name varbinary(50) NOT NULL,
  description varchar(255) DEFAULT NULL,
  diration_hours int(11) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

--
-- Создать внешний ключ
--
ALTER TABLE unit
ADD CONSTRAINT FK_unit_course_id FOREIGN KEY (course_id)
REFERENCES course (id);

--
-- Создать таблицу `lesson`
--
CREATE TABLE IF NOT EXISTS lesson (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  unit_id bigint(20) NOT NULL,
  name varchar(50) NOT NULL,
  description varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

--
-- Создать внешний ключ
--
ALTER TABLE lesson
ADD CONSTRAINT FK_lesson_unit FOREIGN KEY (unit_id)
REFERENCES unit (id);

--
-- Создать таблицу `video`
--
CREATE TABLE IF NOT EXISTS video (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  lesson_id bigint(20) NOT NULL,
  name varchar(50) NOT NULL,
  description varchar(255) DEFAULT NULL,
  load_file varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

--
-- Создать внешний ключ
--
ALTER TABLE video
ADD CONSTRAINT FK_video_lesson_id FOREIGN KEY (lesson_id)
REFERENCES lesson (id);

--
-- Создать таблицу `test`
--
CREATE TABLE IF NOT EXISTS test (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  lesson_id bigint(20) NOT NULL,
  name varchar(50) NOT NULL,
  description varchar(255) DEFAULT NULL,
  load_file varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

--
-- Создать внешний ключ
--
ALTER TABLE test
ADD CONSTRAINT FK_test_lesson_id FOREIGN KEY (lesson_id)
REFERENCES lesson (id);

--
-- Создать таблицу `task`
--
CREATE TABLE IF NOT EXISTS task (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  lesson_id bigint(20) NOT NULL,
  name varchar(50) NOT NULL,
  description varchar(255) DEFAULT NULL,
  load_file varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

--
-- Создать внешний ключ
--
ALTER TABLE task
ADD CONSTRAINT FK_task_lesson_id FOREIGN KEY (lesson_id)
REFERENCES lesson (id);

--
-- Создать таблицу `role`
--
CREATE TABLE IF NOT EXISTS role (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

--
-- Создать таблицу `user`
--
CREATE TABLE IF NOT EXISTS user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  first_name varchar(50) NOT NULL,
  last_name varchar(50) NOT NULL,
  password varchar(50) NOT NULL,
  login varchar(50) NOT NULL,
  role_id bigint(20) NOT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

--
-- Создать внешний ключ
--
ALTER TABLE user
ADD CONSTRAINT FK_user_role_id FOREIGN KEY (role_id)
REFERENCES role (id);

--
-- Создать таблицу `user_lesson_progress`
--
CREATE TABLE IF NOT EXISTS user_lesson_progress (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  user_id bigint(20) NOT NULL,
  lesson_id bigint(20) NOT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

--
-- Создать внешний ключ
--
ALTER TABLE user_lesson_progress
ADD CONSTRAINT FK_lesson_id FOREIGN KEY (lesson_id)
REFERENCES lesson (id);

--
-- Создать внешний ключ
--
ALTER TABLE user_lesson_progress
ADD CONSTRAINT FK_user_id FOREIGN KEY (user_id)
REFERENCES user (id);

--
-- Создать таблицу `author`
--
CREATE TABLE IF NOT EXISTS author (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  first_name varchar(50) NOT NULL,
  last_name varchar(50) NOT NULL,
  specialization varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

--
-- Создать таблицу `author_unit`
--
CREATE TABLE IF NOT EXISTS author_unit (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  author_id bigint(20) NOT NULL,
  unit_id bigint(20) NOT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

--
-- Создать внешний ключ
--
ALTER TABLE author_unit
ADD CONSTRAINT FK_author_id FOREIGN KEY (author_id)
REFERENCES author (id);

--
-- Создать внешний ключ
--
ALTER TABLE author_unit
ADD CONSTRAINT FK_unit_id FOREIGN KEY (unit_id)
REFERENCES unit (id);

-- 
-- Вывод данных для таблицы course
--
-- Таблица mooc.course не содержит данных

-- 
-- Вывод данных для таблицы role
--
-- Таблица mooc.role не содержит данных

-- 
-- Вывод данных для таблицы unit
--
-- Таблица mooc.unit не содержит данных

-- 
-- Вывод данных для таблицы user
--
-- Таблица mooc.user не содержит данных

-- 
-- Вывод данных для таблицы lesson
--
-- Таблица mooc.lesson не содержит данных

-- 
-- Вывод данных для таблицы author
--
-- Таблица mooc.author не содержит данных

-- 
-- Вывод данных для таблицы video
--
-- Таблица mooc.video не содержит данных

-- 
-- Вывод данных для таблицы user_lesson_progress
--
-- Таблица mooc.user_lesson_progress не содержит данных

-- 
-- Вывод данных для таблицы test
--
-- Таблица mooc.test не содержит данных

-- 
-- Вывод данных для таблицы task
--
-- Таблица mooc.task не содержит данных

-- 
-- Вывод данных для таблицы author_unit
--
-- Таблица mooc.author_unit не содержит данных

-- 
-- Восстановить предыдущий режим SQL (SQL mode)
-- 
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;

-- 
-- Включение внешних ключей
-- 
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;