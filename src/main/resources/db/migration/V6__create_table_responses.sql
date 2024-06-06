CREATE TABLE responses
(code int  AUTO_INCREMENT NOT NULL,
message varchar(4000),
topic int,
creationdate datetime,
author int,
solution varchar(4000),
PRIMARY KEY(code),
FOREIGN KEY(topic)
REFERENCES topic(code),
FOREIGN KEY(author)
REFERENCES user(code)
);