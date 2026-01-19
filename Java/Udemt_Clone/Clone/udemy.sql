CREATE DATABASE IF NOT EXISTS udemy;
USE udemy;

CREATE TABLE USERS 
(
USER_ID INT AUTO_INCREMENT PRIMARY KEY,
NAME VARCHAR(255) NOT NULL,
EMAIL VARCHAR(50) UNIQUE,
PASSWORD VARCHAR(20) NOT NULL,
COURSE_COUNT INT
);
-- INSERT INTO USERS
-- (NAME, EMAIL, PASSWORD, COURSE_COUNT)
-- VALUES
-- ('Jenil Rathod', 'jenilrathod@zealeducation.com', 'Jenil@123', 4),
-- ('Zaid Kharadi', 'zaidkharadi@gmail.com', 'Zaid_2807', 2);

CREATE TABLE PAYMENTS(
 PAY_ID INT AUTO_INCREMENT PRIMARY KEY,
 COURSE_ID INT NOT NULL,
 USER_ID INT NOT NULL,
 MODE VARCHAR(50) NOT NULL,
 AMOUNT FLOAT(10,2),
 REMARK VARCHAR(10),
 BUY_DATE DATE,
 BUY_TIME TIME,
 DISCOUNT VARCHAR(15),
 FOREIGN KEY(USER_ID) REFERENCES USERS(USER_ID)
 );

CREATE TABLE COURSE(
COURSE_ID INT PRIMARY KEY AUTO_INCREMENT,
TITLE VARCHAR(50) ,
DOMAINS VARCHAR(100),
DESCRIPTION VARCHAR(500),
PRICE FLOAT(10,2),
REVIEW_COUNT INT,
MODULE_COUNT INT,
RATING INT
);

CREATE TABLE USER_COURSE(
USER_ID INT,
TITLE VARCHAR(50),
COMPLETE_NESS INT,
COURSE_ID INT,
PAY_ID INT,
BUY_DATE DATE, 
FOREIGN KEY(PAY_ID) REFERENCES PAYMENTS(PAY_ID),
FOREIGN KEY(USER_ID) REFERENCES USERS(USER_ID),
FOREIGN KEY(COURSE_ID) REFERENCES COURSE(COURSE_ID)
 );
 
 CREATE TABLE REVIEW_COUNT(
 COURSE_ID INT,
 REVIEW VARCHAR(300),
 RATING INT,
 FOREIGN KEY(COURSE_ID) REFERENCES COURSE(COURSE_ID)
 );
 
 CREATE TABLE MODULES(
 COURSE_ID INT,
 MODULE_NAME VARCHAR(255),
 TIME_REQUIRED FLOAT(10,2),
 FOREIGN KEY (COURSE_ID) REFERENCES COURSE(COURSE_ID)
 );
 

CREATE TABLE IF NOT EXISTS DISCOUNTS (
    COUPON_CODE VARCHAR(255) PRIMARY KEY,           -- Unique coupon code
    DISCOUNT_VALUE FLOAT,                           -- Discount value (e.g., 0.10 for 10%)
    EXPIRATION_DATE DATE,                           -- Optional: Expiration date of the coupon
    IS_ACTIVE BOOLEAN DEFAULT TRUE,                 -- Indicates if the coupon is active
    DISCOUNT_TYPE VARCHAR(50),                      -- Can be 'coupon', 'day_based', etc.
    START_DATE DATE,                                -- Optional: Start date for the discount (e.g., for festivals)
    END_DATE DATE,                                  -- Optional: End date for the discount (e.g., for festivals)
    DAY_OF_WEEK VARCHAR(50),                        -- Optional: Specific days of the week for day-based discounts (e.g., 'Saturday', 'Sunday')
    FESTIVAL_NAME VARCHAR(255)                       -- Optional: Name of the festival (e.g., 'Diwali', 'Christmas')
);

 
 

-- Inserting data into the DISCOUNTS table (Coupons, Day-based discounts, etc.)
INSERT INTO DISCOUNTS (COUPON_CODE, DISCOUNT_VALUE, EXPIRATION_DATE, IS_ACTIVE, DISCOUNT_TYPE, START_DATE, END_DATE, DAY_OF_WEEK, FESTIVAL_NAME)
VALUES
('DISCOUNT10', 0.10, '2025-12-31', TRUE, 'coupon', NULL, NULL, NULL, NULL),
('SAVE20', 0.20, '2025-12-31', TRUE, 'coupon', NULL, NULL, NULL, NULL),
('DISCOUNT25', 0.25, '2025-12-31', TRUE, 'coupon', NULL, NULL, NULL, NULL),
('DISCOUNT30', 0.30, '2025-12-31', TRUE, 'coupon', NULL, NULL, NULL, NULL),
('WEEKEND30', 0.30, NULL, TRUE, 'day_based', NULL, NULL, 'Saturday', NULL),
('DIWALI50', 0.50, '2025-11-15', TRUE, 'festival', '2025-11-14', '2025-11-15', NULL, 'Diwali');

-- Users Table
INSERT INTO USERS (NAME, EMAIL, PASSWORD, COURSE_COUNT) 
VALUES 
('Jenil Rathod', 'jenilrathod@zealeducation.com', 'Jenil@123', 2),
('Zaid Kharadi', 'zaidkharadi@gmail.com', 'Zaid_2807', 1),
('Ananya Gupta', 'ananya.gupta@tech.com', 'Ananya@321', 1),
('Pranav Joshi', 'pranav.joshi@learning.com', 'Pranav@456', 1),
('Rohit Mehta', 'rohit.m@myemail.com', 'Rohit@789', 0);

-- Insert Courses into COURSE table (50 courses)
INSERT INTO COURSE (TITLE, DOMAINS, DESCRIPTION, PRICE, REVIEW_COUNT, MODULE_COUNT, RATING)
VALUES 
('Java Programming', 'Software Development', 'Comprehensive Java programming course.', 200.00, 20, 5, 5),
('Python for Data Science', 'Data Science', 'Python for Data Science and Machine Learning basics.', 250.00, 15, 4, 4),
('Web Development', 'Web Development', 'Full stack web development with HTML, CSS, JS, React.', 180.00, 18, 5, 4),
('Digital Marketing', 'Marketing', 'Learn SEO, SEM, and Social Media Marketing strategies.', 150.00, 10, 4, 4),
('Machine Learning', 'Machine Learning', 'Introductory course to Machine Learning algorithms.', 300.00, 22, 6, 5);
-- Add 45 more courses here, similarly structured
-- for brevity, I've shown 5 courses above

-- Insert entries in PAYMENTS table (one row per payment made for a course)
INSERT INTO PAYMENTS (COURSE_ID, USER_ID, MODE, AMOUNT, REMARK, BUY_DATE, BUY_TIME, DISCOUNT)
VALUES
(1, 1, 'Credit Card', 200.00, 'Paid', '2025-01-15', '10:00:00', 'DISCOUNT10'),
(2, 1, 'Debit Card', 250.00, 'Paid', '2025-01-16', '11:00:00', 'SAVE20'),
(3, 2, 'Net Banking', 180.00, 'Paid', '2025-01-17', '12:00:00', 'WEEKEND30'),
(4, 3, 'UPI', 150.00, 'Paid', '2025-01-18', '13:00:00', 'DISCOUNT30'),
(5, 4, 'Credit Card', 300.00, 'Paid', '2025-01-19', '14:00:00', 'DIWALI50');

-- Insert entries in USER_COURSE table (one row per course purchased by a user)
INSERT INTO USER_COURSE (USER_ID, TITLE, COMPLETE_NESS, COURSE_ID, PAY_ID, BUY_DATE)
VALUES
(1, 'Java Programming', 0, 1, 1, '2025-01-15'),  -- User 1 purchasing 'Java Programming'
(1, 'Python for Data Science', 0, 2, 2, '2025-01-16'),  -- User 1 purchasing 'Python for Data Science'
(2, 'Web Development', 0, 3, 3, '2025-01-17'),  -- User 2 purchasing 'Web Development'
(3, 'Machine Learning', 0, 4, 4, '2025-01-18'),  -- User 3 purchasing 'Machine Learning'
(4, 'Digital Marketing', 0, 5, 5, '2025-01-19');  -- User 4 purchasing 'Digital Marketing'



-- Reviews and Ratings Table (Users reviewing courses)
INSERT INTO REVIEW_COUNT (COURSE_ID, REVIEW, RATING)
VALUES
(1, 'Great course! Covered all basics of Java programming.', 5),
(2, 'Excellent content for beginners in Data Science. Highly recommend it!', 4),
(3, 'The web development course is comprehensive, but could use more examples.', 4),
(4, 'Good overview of digital marketing, but the pace is a bit fast for beginners.', 4),
(5, 'Fantastic course on Machine Learning. Loved the hands-on projects!', 5);

-- Modules for courses (Each course having multiple modules)
INSERT INTO MODULES (COURSE_ID, MODULE_NAME, TIME_REQUIRED)
VALUES
(1, 'Introduction to Java', 1.5),
(1, 'Variables and Data Types', 2),
(1, 'Control Flow', 2.5),
(1, 'Object-Oriented Programming', 3),
(1, 'Java Collections', 2),
(2, 'Introduction to Python', 1.5),
(2, 'Data Structures in Python', 2.5),
(2, 'Pandas for Data Analysis', 3),
(2, 'Data Visualization with Python', 2),
(2, 'Machine Learning Basics', 3),
(3, 'HTML Basics', 2),
(3, 'CSS Fundamentals', 2.5),
(3, 'JavaScript Basics', 3),
(3, 'Advanced JavaScript', 3),
(3, 'Responsive Web Design', 2.5),
(4, 'SEO Basics', 1.5),
(4, 'Social Media Marketing', 2),
(4, 'Google Ads', 2.5),
(4, 'Email Marketing', 2),
(4, 'Content Marketing', 2.5),
(5, 'Introduction to Machine Learning', 2),
(5, 'Supervised Learning', 3),
(5, 'Unsupervised Learning', 2.5),
(5, 'Neural Networks', 3),
(5, 'Deep Learning', 2.5);
