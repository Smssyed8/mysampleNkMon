INSERT INTO account
       (name, username, email, mobile_phone, no_of_dependants, password, city_id, nationality, enabled, created_on, created_by, approved)
VALUES
       ('Admin', 'baligcoup8@gmail.com', 'baligcoup8@gmail.com', '93433527', 0, '$2a$10$9NhAigH0vdTPk1M45AVSYO1UpA0ZQSl1ce6drvP4KdPzlBHnnHGm2', (SELECT id FROM city WHERE city ='Doha'), (SELECT id FROM country WHERE country ='Qatar'), TRUE, NOW(), 1, TRUE),
       ('Candidate', 'candidate@gmail.com', 'candidate@gmail.com', '95920345', 0,  '$2a$10$9NhAigH0vdTPk1M45AVSYO1UpA0ZQSl1ce6drvP4KdPzlBHnnHGm2', (SELECT id FROM city WHERE city ='Doha'), (SELECT id FROM country WHERE country ='Qatar'), TRUE, NOW(), 2, TRUE),
       ('Employer', 'employer@gmail.com', 'employer@gmail.com', '95920323', 0,  '$2a$10$9NhAigH0vdTPk1M45AVSYO1UpA0ZQSl1ce6drvP4KdPzlBHnnHGm2', (SELECT id FROM city WHERE city ='Doha'), (SELECT id FROM country WHERE country ='Qatar'), TRUE, NOW(), 2, TRUE);
