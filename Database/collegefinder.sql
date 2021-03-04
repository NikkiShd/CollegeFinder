CREATE DATABASE College_finder;
USE College_finder;


CREATE TABLE Colleges(college_id INT PRIMARY KEY AUTO_INCREMENT  , college_name VARCHAR(100) NOT NULL  ,
college_city VARCHAR(25) NOT NULL , college_state ENUM('Andhra Pradesh','Arunachal Pradesh',
'Assam','Bihar','Chhattisgarh','New Delhi','Goa','Gujarat','Haryana','Himachal Pradesh',
'Jharkhand','Karnataka','Kerala','Madhya Pradesh','Maharashtra',
'Manipur','Meghalaya','Mizoram','Nagaland','Odisha','Punjab','Rajhasthan','Sikkim',
'Tamil Nadu','Telangana','Tripura','Uttarakhand','Uttar Pradesh','West Bengal') NOT NULL  , college_stream ENUM('Engineering','Medical') NOT null, 
college_rank INT , cutoff_rank INT  );
ALTER TABLE colleges AUTO_INCREMENT=1;




INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('IIT Bombay','Mumbai',
'Maharashtra','Engineering',1,100);

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('ICT Mumbai','Mumbai',
'Maharashtra','Engineering',2,200);

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('Visvesvaraya Institute of Tech(VNIT)','Nagpur',
'Maharashtra','Engineering',3,300);

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('College of Engineering','Pune',
'Maharashtra','Engineering',4,400);

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('NMIMS','Mumbai',
'Maharashtra','Engineering',5,500);






INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('Armed Forces Medical College ','Pune',
'Maharashtra','Medical',1,100);

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('Grant Medical College','Mumbai',
'Maharashtra','Medical',2,200);

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('K.J Somaiya Medical College','Nagpur',
'Maharashtra','Medical',3,300);

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('Rajiv Gandhi College','Mumbai',
'Maharashtra','Medical',4,400);

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('ISth GS Medical College','Mumbai',
'Maharashtra','Medical',5,500);










INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('IIT Delhi','New Delhi',
'New Delhi','Engineering',1,100);

 

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('Netaji Subhas Institute of Tech','New Delhi',
'New Delhi','Engineering',2,200);

 

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('National Institute of Tech','New Delhi',
'New Delhi','Engineering',3,300);

 

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('Ambedkar Institute of Advanced Comm Techn & Research','New Delhi',
'New Delhi','Engineering',4,400);

 

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('Bhagwan Parshuram Institute of Tech','New Delhi',
'New Delhi','Engineering',5,500);

 
 
 
 
 
 

 


INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('All India Institute of Medical Sciences ','New Delhi',
'New Delhi','Medical',1,100);

 

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('Institute of Liver and Biliary Sciences','New Delhi',
'New Delhi','Medical',2,200);

 

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('Maulana Azad Medical College','New Delhi',
'New Delhi','Medical',3,300);

 

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('Jamia Hamdard University','New Delhi',
'New Delhi','Medical',4,400);

 

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('Vardhman Mahavir Medical College','New Delhi',
'New Delhi','Medical',5,500);








INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('IIT Chennai','Chennai',
'Tamil Nadu','Engineering',1,100);

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('NIT TRICHY','Tiruchirappalli',
'Tamil Nadu','Engineering',2,200);

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('Anna University','Chennai',
'Tamil Nadu','Engineering',3,300);

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('Vellore Institute of Technology','Vellore',
'Tamil Nadu','Engineering',4,500);

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('SRM Institute of Science and Technology','Chennai',
'Tamil Nadu','Engineering',5,600);









INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('Christian Medical College','Vellore',
'Tamil Nadu','Medical',1,100);

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('Sri Ramachandra Institute of Hr Ed. and Res.','Chennai',
'Tamil Nadu','Medical',2,200);

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('SRM Institute of Technology','Kanchipuram',
'Tamil Nadu','Medical',3,400);

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('Saveetha Medical College','Chennai',
'Tamil Nadu','Medical',4,500);

INSERT INTO Colleges (college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('Annamalai University','Chidambaram',
'Tamil Nadu','Medical',5,500);













INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('IIT Kanpur','Kanpur',
'Uttar Pradesh','Engineering',1,100);

 

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('IIT Varanasi','Varnasi',
'Uttar Pradesh','Engineering',2,200);

 

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('Kashi Institute of Technology','Varnasi',
'Uttar Pradesh','Engineering',3,300);

 

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('Amity University','Noida',
'Uttar Pradesh','Engineering',4,400);

 

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('Aligarh Muslim University','Aligarh',
'Uttar Pradesh','Engineering',5,500);

 
 
 
 
 
 
 

 

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('Sanjay Gandhi Post Graduate Inst. ','Lucknow',
'Uttar Pradesh','Medical',1,100);

 

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('Banaras Hindu University','Varanasi',
'Uttar Pradesh','Medical',2,200);

 

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('King’s George Medical University','Lucknow',
'Uttar Pradesh','Medical',3,300);

 

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('The Institute of Medical Sciences','Varanasi',
'Uttar Pradesh','Medical',4,400);

 

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('Eras Lucknow Medical College Hospital','Lucknow',
'Uttar Pradesh','Medical',5,500);































INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('Basaveshwar Engineering College','Bagalkot',
'Karnataka','Engineering',1,100);

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('BMS College of Engineering','Bengaluru',
'Karnataka','Engineering',2, 200);

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('RV College of Engineering','Bangaluru',
'Karnataka','Engineering',3,300);

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('Malnad College of Engineering','Hassan',
'Karnataka','Engineering',4,400);

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('KLE Technological University','Hubli',
'Karnataka','Engineering',5,500);















INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('National Inst. of Mental & Neuro Sciences','Bangalore',
'Karnataka','Medical',1,150);

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('Kasturba Medical College','Manipal',
'Karnataka','Medical',2,200);

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('St. Johns Medical Bengaluru','Bengaluru',
'Karnataka','Medical',3,300);

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('JSS Medical College','Mysore',
'Karnataka','Medical',4,400);

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('Kasturba Medical College','Mangaluru',
'Karnataka','Medical',5,500);














INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('IIT Hyderabad','Hyderabad',
'Telangana','Engineering',1,100);

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('Osmania University','Hyderabad',
'Telangana','Medical',2, 200);

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('NIT Warangal','Warangal',
'Telangana','Engineering',3,300);

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('Gandhi Medical College','Hyderabad',
'Telangana','Medical',4,400);

INSERT INTO Colleges(college_name,college_city,college_state,college_stream,college_rank,cutoff_rank)
 VALUES('JNTUH','Hyderabad',
'Telangana','Engineering',5,500);





CREATE TABLE studentdetails(
student_id INT(11) NOT NULL AUTO_INCREMENT ,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
PASSWORD VARCHAR(50) NOT NULL,
email_id VARCHAR(50) NOT NULL UNIQUE,
mobile_number VARCHAR(50) NOT NULL,
gender ENUM('m','f') NOT NULL,
dob DATE,
registration_date DATETIME NOT NULL,
PRIMARY KEY(student_id));





CREATE TABLE application_details (application_id int not null AUTO_INCREMENT,application_sid int not NULL,
application_cid int not NULL, first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50), email_id VARCHAR(50) NOT NULL, House_Number INT NOT NULL,
Street_name VARCHAR(50) NOT NULL, city VARCHAR(50) NOT NULL,
state VARCHAR(50) NOT NULL , zipcode VARCHAR(6)  , school_name VARCHAR(100) NOT NULL,
school_GPA INT NOT NULL, student_rank INT NOT NULL,
STATUS VARCHAR(25) NOT NULL,
PRIMARY KEY(application_id),
FOREIGN KEY(application_sid) REFERENCES studentdetails(student_id),
FOREIGN KEY(application_cid) REFERENCES colleges(college_id));
ALTER TABLE application_details AUTO_INCREMENT=100;


























