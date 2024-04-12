CREATE TABLE Students ( roll_no INT PRIMARY KEY, name VARCHAR(30), email_id  VARCHAR(35));
INSERT INTO Students VALUES
(118,"Harinisri","717822p118@kce.ac.in"),
(125,"Kavya","717822p125@kce.ac.in"),
(128,"Krisha","717822p128@kce.ac.in"),
(147,"Santhiya","717822p147@kce.ac.in"),
(319,"Jothsana devi","717822p319@kce.ac.in"),
(349,"Sowmya","717822p349@kce.ac.in"),
(352,"Subathra","717822p352@kce.ac.in");

CREATE TABLE Courses(course_id VARCHAR(10), course_name VARCHAR(40), faculty VARCHAR(30));
INSERT INTO Courses VALUES
("21PE04","Advanced Java Programming","Sharmila"),
("21PE01","Advanced Data Structures","Arunkumar"),
("21PD03","Operating systems","Mariyammal"),
("21PD08","Computer Architecture","Ravichandran"),
("21OB12","Probabilty and statistics","Ganesh"),
("21OG03","Essence of Indian Traditional Knowledge","Susheela");

CREATE INDEX idx_course_id ON Courses (course_id);

CREATE TABLE Enrollments (enrollment_id INT AUTO_INCREMENT PRIMARY KEY , roll_no INT , course_id VARCHAR(10),
FOREIGN KEY roll_no Students(roll_no),
FOREIGN KEY course_id Enrollments(course_id)
);
INSERT INTO Enrollments (roll_no,course_id) VALUES
(118,"21PE04"),(118,"21PE01"),(118,"21PD03"),(118,"21PD08"),(118,"21OG03"),(118,"21OB12"),
(125,"21PE04"),(125,"21PE01"),(125,"21PD03"),(125,"21PD08"),(125,"21OG03"),(125,"21OB12"),
(128,"21PE04"),(128,"21PE01"),(128,"21PD03"),(128,"21PD08"),(128,"21OG03"),(128,"21OB12"),
(147,"21PE04"),(147,"21PE01"),(147,"21PD03"),(147,"21PD08"),(147,"21OG03"),(147,"21OB12"),
(319,"21PE04"),(319,"21PE01"),(319,"21PD03"),(319,"21PD08"),(319,"21OG03"),(319,"21OB12"),
(349,"21PE04"),(349,"21PE01"),(349,"21PD03"),(349,"21PD08"),(349,"21OG03"),(349,"21OB12"),
(352,"21PE04"),(352,"21PE01"),(352,"21PD03"),(352,"21PD08"),(352,"21OG03"),(352,"21OB12");


CREATE TABLE Faculty (faculty_id INT AUTO_INCREMENT PRIMARY KEY , name VARCHAR(30) , department VARCHAR(10), course VARCHAR(40));
INSERT INTO Faculty (name,department,course) VALUES
("Sharmila","CSE","Advanced Java Programming"),
("Arunkumar","CSE","Advanced Data Structures"),
("Mariyammal","CSE","Operating systems"),
("Ravichandran","CSE","Computer Architecture"),
("Ganesh","S&H","Probability and Statistics"),
("Susheela","S&H","Essence of Indian Traditional Knowledge");
