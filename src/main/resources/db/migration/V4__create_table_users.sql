CREATE TABLE user
(code int AUTO_INCREMENT NOT NULL,
username varchar(500),
email varchar(500),
password varchar(4000),
type_profile int,
PRIMARY KEY(code),
FOREIGN KEY(type_profile)
REFERENCES profile(code)
);