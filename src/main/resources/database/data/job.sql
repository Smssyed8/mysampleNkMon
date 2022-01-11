INSERT INTO job
       (employer_id, job_title, job_role, city_id, job_level, job_type, company_industry, type_of_work, monthly_salary, professional_summary, notice_period, years_of_experience, skills, description, last_date_for_application, min_salary, max_salary, qualification, created_on, updated_on, updated_by, required_gender)
VALUES
	(1, 'Job Title 1', 1, (SELECT id FROM city WHERE city ='Doha'), 1, 1, 1, 'Type Of Work 1', 2000, 'professional summary 1', 2, 22, 'Skills Set 1', 'Description Job 1', NOW(), 2000, 2000000, 'Qualification 1', NOW(), NOW(), 1, 'm'),
	(1, 'Job Title 2', 2, (SELECT id FROM city WHERE city ='Doha'), 2, 2, 2, 'Type Of Work 2', 2000, 'professional summary 2', 2, 22, 'Skills Set 2', 'Description Job 2', NOW(), 2000, 2000000, 'Qualification 2', NOW(), NOW(), 1, 'f');
