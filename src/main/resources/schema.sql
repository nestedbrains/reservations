CREATE TABLE ROOM(
         id INTEGER AUTO_INCREMENT PRIMARY KEY,
         name VARCHAR (16) NOT NULL,
         room_number CHAR (6) NOT NULL UNIQUE ,
         bed_info CHAR (6) NOT null
);