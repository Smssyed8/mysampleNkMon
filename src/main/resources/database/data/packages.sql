INSERT INTO packages
       (package_name, package_description, price, selling_price, cv_search_limit, job_posting_limit, is_unlimited_cv_search, is_unlimited_job_posting, duration_in_month, created_on, updated_on)
VALUES
	('Premium Job Posting', 'Unlimited application, Active for 60 days', 250, 225, 0, 0, true, true, 2, NOW(), NOW()),
       ('One Month CV Search + Two Job Postings', 'Post 2 job advertisements for 60 days, One Month access to our CV database and contact up to 500 candidates', 1298, 999.90, 500, 2, false, false, 2, NOW(), NOW()),
       ('1-Month CV Search', 'Use over 30 filters including nationality, location, and experience, 13,000 fresh CVs every day', 1000, 900, 0, 0, true, true, 1, NOW(), NOW());
