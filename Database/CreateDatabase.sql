-- DROP DATABASE LAB_ReportGradeSystem;
-- CREATE DATABASE LAB_ReportGradeSystem;
USE LAB_ReportGradeSystem;


CREATE TABLE Account (
    username VARCHAR(150) NOT NULL PRIMARY KEY,
    `password` VARCHAR(150) NOT NULL
);

CREATE TABLE `Role`(
	roleId int NOT NULL,
	roleName varchar(150),
	CONSTRAINT PK_Role PRIMARY KEY (roleId)
);

CREATE TABLE Account_Role(
	username varchar(150) NOT NULL,
	roleId int NOT NULL,
	CONSTRAINT PK_Account_Role PRIMARY KEY (username, roleId)
);
ALTER TABLE Account_Role ADD CONSTRAINT FK_Account_Role_Account FOREIGN KEY(username)
REFERENCES Account (username);
ALTER TABLE Account_Role ADD CONSTRAINT FK_Account_Role_Role FOREIGN KEY(roleId)
REFERENCES `Role` (roleId);


CREATE TABLE Feature(
	featureId int NOT NULL, 
	featureName varchar(150),
	`url` varchar(150),
	CONSTRAINT PK_Feature PRIMARY KEY (featureId)
);

CREATE TABLE Role_Feature 
(
	roleId int NOT NULL,
	featureId int NOT NULL,
	CONSTRAINT PK_Role_Feature PRIMARY KEY (roleId, featureId)
);
ALTER TABLE Role_Feature ADD CONSTRAINT FK_Role_Feature_Role FOREIGN KEY(roleId)
REFERENCES `Role`(roleId);
ALTER TABLE Role_Feature ADD CONSTRAINT FK_Role_Feature_Feature FOREIGN KEY(featureId)
REFERENCES Feature(featureId);


 CREATE TABLE Instructor
 (
	instructorId varchar(20) NOT NULL,
	instructorName nvarchar(100),
	CONSTRAINT PK_Instructor PRIMARY KEY (instructorId),
	username varchar(150) NOT NULL UNIQUE,
    CONSTRAINT FK_Instructor_Account FOREIGN KEY (username) REFERENCES Account(username)
);


CREATE TABLE Curriculum(
	curriculumId varchar(50),
	curriculumName varchar(150),
	CONSTRAINT PK_Curriculum PRIMARY KEY (curriculumId)
);
INSERT INTO Curriculum VALUES ('SE','Software Engineer');


CREATE TABLE Course
(
	courseId varchar(10) NOT NULL,
	courseName nvarchar(100),
	CONSTRAINT PK_Course PRIMARY KEY (courseId)
 );


CREATE TABLE Curriculum_Course(
	curriculumId varchar(50),
	courseId varchar(10), 
	PRIMARY KEY (curriculumId, courseId)
);
ALTER TABLE Curriculum_Course ADD CONSTRAINT FK_CurriculumCourse_Curriculum FOREIGN KEY(curriculumId)
REFERENCES Curriculum (curriculumId);
ALTER TABLE Curriculum_Course ADD CONSTRAINT FK_CurriculumCourse_Course FOREIGN KEY(courseId)
REFERENCES Course (courseId);


CREATE TABLE Student
(
	studentId varchar(8) NOT NULL,
	studentName nvarchar(100),
	CONSTRAINT PK_Student PRIMARY KEY (studentId),
	username varchar(150) NOT NULL UNIQUE,
	curriculumId varchar(50) DEFAULT 'SE',
    CONSTRAINT FK_Student_Account FOREIGN KEY (username) REFERENCES Account(username)
 );
ALTER TABLE Student ADD CONSTRAINT FK_Student_Curriculum FOREIGN KEY(curriculumId)
REFERENCES Curriculum (curriculumId);



CREATE TABLE `Group`
(
	groupId int NOT NULL,
	groupName varchar(20) NULL,
	courseId varchar(10) NULL,
	instructorId varchar(20) NULL,
	CONSTRAINT PK_Group PRIMARY KEY (groupId)
);
ALTER TABLE `Group` ADD CONSTRAINT FK_Group_Course FOREIGN KEY(courseId)
REFERENCES Course (courseId);
ALTER TABLE `Group` ADD CONSTRAINT FK_Group_Instructor FOREIGN KEY(instructorId)
REFERENCES Instructor (instructorId);


 CREATE TABLE Participate
 (
	groupId int NOT NULL,
	studentId varchar(8) NOT NULL,
	CONSTRAINT PK_Participate PRIMARY KEY (groupId, studentId)
);
ALTER TABLE Participate ADD CONSTRAINT FK_Participate_Group FOREIGN KEY(groupId)
REFERENCES `Group` (groupId);
ALTER TABLE Participate ADD CONSTRAINT FK_Participate_Student FOREIGN KEY(studentId)
REFERENCES Student (studentId);


 CREATE TABLE GradeCategory
 (
	gradeCategoryId int NOT NULL,
	gradeCategoryName varchar(50) NOT NULL,
	gradeItemName varchar(150) NOT NULL,
	courseId varchar(10),
	`weight` decimal(5,2),
	CONSTRAINT PK_GradeCategory PRIMARY KEY (gradeCategoryId)
);
ALTER TABLE GradeCategory ADD CONSTRAINT FK_GradeCategory_Course FOREIGN KEY(courseId)
REFERENCES Course (courseId);


CREATE TABLE Semester (
	semesterId varchar(50),
	semesterName varchar(50),
	`year` int,
	startDate date,
	endDate date,
	CONSTRAINT PK_Semester PRIMARY KEY (semesterId)
);

CREATE TABLE Grade 
(
	gradeCategoryId int,
	studentId varchar(8) NOT NULL,
	semesterId varchar(50),
	gradeValue decimal(4,2),
	CONSTRAINT PK_Grade PRIMARY KEY(studentId,gradeCategoryId, semesterId)
);
ALTER TABLE Grade  ADD CONSTRAINT FK_Grade_Semester FOREIGN KEY(semesterId)
REFERENCES Semester (semesterId);
ALTER TABLE Grade  ADD CONSTRAINT FK_Grade_Student FOREIGN KEY(studentId)
REFERENCES Student (studentId);
ALTER TABLE Grade  ADD CONSTRAINT FK_Grade_GradeCategory FOREIGN KEY(gradeCategoryId)
REFERENCES GradeCategory (gradeCategoryId);

/* SQLINES DEMO *** DROP TABLE Semester
--	Thứ tự drop bảng
DROP TABLE Grade;
DROP TABLE Semester;
DROP TABLE GradeCategory;
DROP TABLE Participate;
DROP TABLE `Group`;
DROP TABLE Curriculum_Course;
DROP TABLE Course;
DROP TABLE Student;
DROP TABLE Curriculum;
DROP TABLE Instructor;

DROP TABLE Account_Role;
DROP TABLE Account;
DROP TABLE Role_Feature;
DROP TABLE `Role`;
DROP TABLE Feature;

SELECT * FROM Grade;
SELECT * FROM Semester;
SELECT * FROM GradeCategory;
SELECT * FROM Participate;
SELECT * FROM `Group`;
SELECT * FROM Curriculum_Course;
SELECT * FROM Course;
SELECT * FROM Student;
SELECT * FROM Curriculum;
SELECT * FROM Instructor;

SELECT * FROM Account_Role;
SELECT * FROM Account;
SELECT * FROM Role_Feature;
SELECT * FROM `Role`;
SELECT * FROM Feature;

--	Thứ tự xóa bảng
*/



