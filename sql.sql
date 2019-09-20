DROP SCHEMA IF EXISTS `library`;
CREATE SCHEMA IF NOT EXISTS `library`
    CHARACTER SET `utf8`;

USE `library`;

DROP TABLE IF EXISTS `genre`;
CREATE TABLE `genre`
(
    `id`   BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL
);
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`
(
    `id`   BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS `passport_data`;


DROP TABLE IF EXISTS `library`;
CREATE TABLE `library`
(
    `id`          BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name`        VARCHAR(255) NOT NULL,
    `street`      VARCHAR(255) NOT NULL,
    `houseNumber` VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`
(
    `id`         BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name`       VARCHAR(255) NOT NULL,
    `volume`     BIGINT,
    `genre`   BIGINT,
    `library` BIGINT,
    CONSTRAINT `fk_book_to_genre` FOREIGN KEY (`genre`) REFERENCES `genre` (`id`),
    CONSTRAINT `fk_book_to_library` FOREIGN KEY (`library`) REFERENCES `library` (`id`)

);

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`          BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name`        VARCHAR(255) NOT NULL,
    `password`    VARCHAR(255) NOT NULL,
    `street`      VARCHAR(255) NOT NULL,
    `houseNumber` VARCHAR(255) NOT NULL,
    `role`        BIGINT,
    CONSTRAINT `fk_user_to_role` FOREIGN KEY (`role`) REFERENCES `role` (`id`));

DROP TABLE IF EXISTS `passport_data`;
CREATE TABLE `passport_data`
(
    `id`   BIGINT       NOT NULL PRIMARY KEY,
    `data` VARCHAR(255) NOT NULL,
    CONSTRAINT `fk_passport_data_to_user` FOREIGN KEY (`id`) REFERENCES `user` (`id`)
);

DROP TABLE IF EXISTS `user_book`;
CREATE TABLE `user_book`
(
    `id`         BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `fk_user_id` BIGINT NOT NULL,
    `fk_book_id` BIGINT NOT NULL,
    CONSTRAINT `fk_user_book_to_user` FOREIGN KEY (`fk_user_id`) REFERENCES `user` (`id`),
    CONSTRAINT `fk_user_book_to_book` FOREIGN KEY (`fk_book_id`) REFERENCES `book` (`id`)
);
DROP TABLE IF EXISTS `user_request`;
CREATE TABLE `user_request`
(
    `id`         BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `fk_user_id` BIGINT NOT NULL,
    `fk_book_id` BIGINT NOT NULL,
    CONSTRAINT `fk_user_request_to_user` FOREIGN KEY (`fk_user_id`) REFERENCES `user` (`id`),
    CONSTRAINT `fk_user_request_to_book` FOREIGN KEY (`fk_book_id`) REFERENCES `book` (`id`)
);

-- test data --
INSERT INTO genre (id, name)
VALUES (1, 'fantastic');
INSERT INTO genre (id, name)
VALUES (2, 'detective');
INSERT INTO genre (id, name)
VALUES (3, 'forchild');
INSERT INTO genre (id, name)
VALUES (4, 'classic');
INSERT INTO genre (id, name)
VALUES (5, 'history');

INSERT INTO role (id, name)
VALUES (1, 'user');
INSERT INTO role (id, name)
VALUES (2, 'admin');

INSERT INTO library (id, name, street, houseNumber)
VALUES (1, '1', 'Независимости', '5');
INSERT INTO library (id, name, street, houseNumber)
VALUES (2, '2', 'Партизанский', '12');
INSERT INTO library (id, name, street, houseNumber)
VALUES (3, '3', 'Тимирязева', '45');

INSERT INTO book (id, name, volume, genre, library)
VALUES (1, 'Мастер и Маргарита', 200, 4, 1);
INSERT INTO book (id, name, volume, genre, library)
VALUES (2, 'Евгений Онегин', 160, 4, 1);
INSERT INTO book (id, name, volume, genre, library)
VALUES (3, 'Преступление и наказание', 170, 4, 1);
INSERT INTO book (id, name, volume, genre, library)
VALUES (4, 'Маленький принц', 120, 3, 2);
INSERT INTO book (id, name, volume, genre, library)
VALUES (5, 'Гарри Поттер и философский камень', 155, 3, 2);
INSERT INTO book (id, name, volume, genre, library)
VALUES (6, 'Алиса в Стране чудес', 220, 3, 2);
INSERT INTO book (id, name, volume, genre, library)
VALUES (7, 'Шерлок Холмс', 200, 2, 3);
INSERT INTO book (id, name, volume, genre, library)
VALUES (8, 'Старик и море', 55, 3, 1);
INSERT INTO book (id, name, volume, genre, library)
VALUES (9, 'Два капитана', 320, 3, 1);
INSERT INTO book (id, name, volume, genre, library)
VALUES (10, 'Архипелаг ГУЛАГ', 310, 5, 3);
INSERT INTO book (id, name, volume, genre, library)
VALUES (11, 'На Западном фронте без перемен', 240, 5, 3);
INSERT INTO book (id, name, volume, genre, library)
VALUES (12, 'Мастер и Маргарита', 200, 4, 2);
INSERT INTO book (id, name, volume, genre, library)
VALUES (13, 'Мастер и Маргарита', 200, 4, 3);


INSERT INTO user (id, name, password, street, houseNumber, role)
VALUES (1, 'Геннадий', '1234', 'Юбилейная', 12, 2);
INSERT INTO user (id, name, password, street, houseNumber, role)
VALUES (2, 'Ольга', '1234', 'Юбилейная', 12, 1);

INSERT INTO user_book (id, fk_user_id, fk_book_id)
VALUES (1, 1, 4);
INSERT INTO user_book (id, fk_user_id, fk_book_id)
VALUES (2, 2, 7);
INSERT INTO user_book (id, fk_user_id, fk_book_id)
VALUES (3, 2, 8);

INSERT INTO passport_data (id, data)
VALUES (1, '№12345678 РИ');
INSERT INTO passport_data (id, data)
VALUES (2, '№12342134 ВА');
