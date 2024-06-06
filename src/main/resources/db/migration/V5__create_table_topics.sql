CREATE TABLE topic
(code int AUTO_INCREMENT NOT NULL,
title varchar(500),
message varchar(4000),
creation_date datetime,
status int,
author int,
course int,
PRIMARY KEY(code),
FOREIGN KEY(status)
REFERENCES status(code),
FOREIGN KEY(author)
REFERENCES user(code),
FOREIGN KEY(course)
REFERENCES course(code)
);