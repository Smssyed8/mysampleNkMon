INSERT INTO city
       (city, path, country_id, created_on, updated_on, updated_by)
VALUES
	('Doha', 'image/logos/admin.png', (SELECT id FROM country WHERE country='Qatar'), NOW(), NOW(), 1),
	('Al Rayyan', 'image/logos/admin.png', (SELECT id FROM country WHERE country='Qatar'), NOW(), NOW(), 1),
	('Al Wakra', 'image/logos/admin.png', (SELECT id FROM country WHERE country='Qatar'), NOW(), NOW(), 1),
	('Umm Said', 'image/logos/admin.png', (SELECT id FROM country WHERE country='Qatar'), NOW(), NOW(), 1),
	('Khor Al Udaid', 'image/logos/admin.png', (SELECT id FROM country WHERE country='Qatar'), NOW(), NOW(), 1),
	('Al Khor', 'image/logos/admin.png', (SELECT id FROM country WHERE country='Qatar'), NOW(), NOW(), 1),
	('Ras Laffan Industrial City', 'image/logos/admin.png', (SELECT id FROM country WHERE country='Qatar'), NOW(), NOW(), 1),
	('Mesaieed', 'image/logos/admin.png', (SELECT id FROM country WHERE country='Qatar'), NOW(), NOW(), 1),
	('Madinat Al-Shamal', 'image/logos/admin.png', (SELECT id FROM country WHERE country='Qatar'), NOW(), NOW(), 1),
	('Al Ruwais', 'image/logos/admin.png', (SELECT id FROM country WHERE country='Qatar'), NOW(), NOW(), 1),
	('Al Zubara', 'image/logos/admin.png', (SELECT id FROM country WHERE country='Qatar'), NOW(), NOW(), 1),
	('Dukhan', 'image/logos/admin.png', (SELECT id FROM country WHERE country='Qatar'), NOW(), NOW(), 1);

