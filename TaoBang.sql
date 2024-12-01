create database qltv
use qltv

CREATE TABLE reader (
    id int PRIMARY KEY auto_increment,
    name NVARCHAR(100),
    sex NVARCHAR(10),
    dateofbirth DATE,
    address NVARCHAR(200),
    phonenumber VARCHAR(15),
    Email VARCHAR(100)
);

CREATE TABLE book (
    id int PRIMARY KEY auto_increment,
    name NVARCHAR(200),
    quantity INT
);

CREATE TABLE bookloan (
    id int PRIMARY KEY auto_increment,
    readerid int,
    FOREIGN KEY (readerid) REFERENCES reader(id) ON DELETE CASCADE
);
CREATE TABLE bookloandetail (
    id int auto_increment,
	bookid int,
	quantity int,
	primary key(id,bookid),
    FOREIGN KEY (id) REFERENCES bookloan(id),
	FOREIGN KEY (bookid) REFERENCES book(id)
);

