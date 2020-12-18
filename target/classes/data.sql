DROP TABLE IF EXISTS task;

CREATE TABLE task (id INT AUTO_INCREMENT PRIMARY KEY, description VARCHAR(256) NOT NULL, status_name VARCHAR(100));

INSERT INTO task (description, status_name) VALUES ('asdjfksd','asdfsadf'),('asdjd','asddf'),('ajfksd','asdfs');