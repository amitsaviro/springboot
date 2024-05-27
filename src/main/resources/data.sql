
DROP TABLE IF EXISTS user;

CREATE TABLE user (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    first_name varchar(300) NOT NULL DEFAULT '',
    last_name varchar(300) NOT NULL DEFAULT '',
    email varchar(300) NOT NULL DEFAULT '',
    age int(11) NOT NULL,
    address varchar(300) NOT NULL DEFAULT '',
    register_date varchar(300) ,
    status varchar(300) NOT NULL ,
    PRIMARY KEY (id)
);





