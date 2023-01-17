CREATE TABLE IF NOT EXISTS quiz (
    id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30),
    description VARCHAR(255),
    INDEX(name)
    ) engine=InnoDB;

CREATE TABLE IF NOT EXISTS question (
    id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    question VARCHAR(30),

    correctChoice VARCHAR(255),
    INDEX(name)
    ) engine=InnoDB;