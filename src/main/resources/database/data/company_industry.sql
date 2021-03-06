INSERT INTO company_industry
       (company_industry, sector_id, created_on, updated_on, updated_by)
VALUES
       ('Accounting', (SELECT id FROM sector WHERE sector ='Finance, Insurance, & Legal'), NOW(), NOW(), 1),
       ('Administration Support Services', (SELECT id FROM sector WHERE sector ='Business Support & Marketing'), NOW(), NOW(), 1),
       ('Advertising', (SELECT id FROM sector WHERE sector ='Business Support & Marketing'), NOW(), NOW(), 1),
       ('Aerospace', (SELECT id FROM sector WHERE sector ='Military & Aerospace'), NOW(), NOW(), 1),
       ('Agriculture & Crop Production', (SELECT id FROM sector WHERE sector ='Agriculture, Fishery & Livestock'), NOW(), NOW(), 1),
       ('Airconditioning Plant', (SELECT id FROM sector WHERE sector ='Oil, Energy, & Utilities'), NOW(), NOW(), 1),
       ('Airlines', (SELECT id FROM sector WHERE sector ='Transport, Logistics, & Aviation'), NOW(), NOW(), 1),
       ('Amusement & Recreation Facility', (SELECT id FROM sector WHERE sector ='Leisure, Hospitality & Tourism'), NOW(), NOW(), 1),
       ('Animal Production', (SELECT id FROM sector WHERE sector ='Agriculture, Fishery & Livestock'), NOW(), NOW(), 1),
       ('Architecture', (SELECT id FROM sector WHERE sector ='Construction & Property'), NOW(), NOW(), 1),
       ('Arts & Crafts Supplies', (SELECT id FROM sector WHERE sector ='Retail & Wholesale'), NOW(), NOW(), 1),
       ('Automotive Dealership & Distributor', (SELECT id FROM sector WHERE sector ='Retail & Wholesale'), NOW(), NOW(), 1),
       ('Automotive Manufacture', (SELECT id FROM sector WHERE sector ='Manufacturing, Consumer Goods & Industrial'), NOW(), NOW(), 1),
       ('Automotive Repair, Spare Parts, & Support Services', (SELECT id FROM sector WHERE sector ='Engineering & Technical Services'), NOW(), NOW(), 1),
       ('Aviation Support Services', (SELECT id FROM sector WHERE sector ='Transport, Logistics, & Aviation'), NOW(), NOW(), 1),
       ('Banking', (SELECT id FROM sector WHERE sector ='Finance, Insurance, & Legal'), NOW(), NOW(), 1),
       ('Biotechnology', (SELECT id FROM sector WHERE sector ='Manufacturing, Consumer Goods & Industrial'), NOW(), NOW(), 1),
       ('Bookshop & Consumer Media', (SELECT id FROM sector WHERE sector ='Retail & Wholesale'), NOW(), NOW(), 1),
       ('Broadcast Media Production', (SELECT id FROM sector WHERE sector ='Arts, Entertainment & Media'), NOW(), NOW(), 1),
       ('Business Consultancy Services', (SELECT id FROM sector WHERE sector ='Business Support & Marketing'), NOW(), NOW(), 1),
       ('Business Process Outsourcing (BPO)', (SELECT id FROM sector WHERE sector ='Business Support & Marketing'), NOW(), NOW(), 1),
       ('Business Support Services', (SELECT id FROM sector WHERE sector ='Business Support & Marketing'), NOW(), NOW(), 1),
       ('Call Centers & Customer Care Outsourcing', (SELECT id FROM sector WHERE sector ='Business Support & Marketing'), NOW(), NOW(), 1),
       ('Catering, Food Service, & Restaurant', (SELECT id FROM sector WHERE sector ='Leisure, Hospitality & Tourism'), NOW(), NOW(), 1),
       ('Chemicals Manufacture', (SELECT id FROM sector WHERE sector ='Manufacturing, Consumer Goods & Industrial'), NOW(), NOW(), 1),
       ('Civil Engineering', (SELECT id FROM sector WHERE sector ='Construction & Property'), NOW(), NOW(), 1),
       ('Computer Hardware & High-Tech Manufacture', (SELECT id FROM sector WHERE sector ='Manufacturing, Consumer Goods & Industrial'), NOW(), NOW(), 1),
       ('Construction & Building', (SELECT id FROM sector WHERE sector ='Construction & Property'), NOW(), NOW(), 1),
       ('Consumer Electronics', (SELECT id FROM sector WHERE sector ='Retail & Wholesale'), NOW(), NOW(), 1),
       ('Consumer Packaged Goods Manufacture', (SELECT id FROM sector WHERE sector ='Manufacturing, Consumer Goods & Industrial'), NOW(), NOW(), 1),
       ('Corporate Management Office', (SELECT id FROM sector WHERE sector ='Conglomerate & Holding Group'), NOW(), NOW(), 1),
       ('Crude Petroleum & Gas Extraction', (SELECT id FROM sector WHERE sector ='Oil, Energy, & Utilities'), NOW(), NOW(), 1),
       ('Data Hosting & Storage', (SELECT id FROM sector WHERE sector ='IT & Telecom'), NOW(), NOW(), 1),
       ('Dental Center & Clinic', (SELECT id FROM sector WHERE sector ='Healthcare & Pharma'), NOW(), NOW(), 1),
       ('Distribution & Logistics', (SELECT id FROM sector WHERE sector ='Transport, Logistics, & Aviation'), NOW(), NOW(), 1),
       ('Economics & Financial Consulting', (SELECT id FROM sector WHERE sector ='Finance, Insurance, & Legal'), NOW(), NOW(), 1),
       ('Electric Power Production & Transmission', (SELECT id FROM sector WHERE sector ='Oil, Energy, & Utilities'), NOW(), NOW(), 1),
       ('Electrical Engineering', (SELECT id FROM sector WHERE sector ='Engineering & Technical Services'), NOW(), NOW(), 1),
       ('Entertainment', (SELECT id FROM sector WHERE sector ='Arts, Entertainment & Media'), NOW(), NOW(), 1),
       ('Events Management', (SELECT id FROM sector WHERE sector ='Business Support & Marketing'), NOW(), NOW(), 1),
       ('FMCG', (SELECT id FROM sector WHERE sector ='Manufacturing, Consumer Goods & Industrial'), NOW(), NOW(), 1),
       ('Facilities & Property Management', (SELECT id FROM sector WHERE sector ='Construction & Property'), NOW(), NOW(), 1),
       ('Fashion & Apparel', (SELECT id FROM sector WHERE sector ='Retail & Wholesale'), NOW(), NOW(), 1),
       ('Fashion Design', (SELECT id FROM sector WHERE sector ='Arts, Entertainment & Media'), NOW(), NOW(), 1),
       ('Financial Auditing', (SELECT id FROM sector WHERE sector ='Finance, Insurance, & Legal'), NOW(), NOW(), 1),
       ('Financial Services', (SELECT id FROM sector WHERE sector ='Finance, Insurance, & Legal'), NOW(), NOW(), 1),
       ('Fishing', (SELECT id FROM sector WHERE sector ='Agriculture, Fishery & Livestock'), NOW(), NOW(), 1),
       ('Fit-Out & Joinery', (SELECT id FROM sector WHERE sector ='Construction & Property'), NOW(), NOW(), 1),
       ('Food & Beverage Production', (SELECT id FROM sector WHERE sector ='Manufacturing, Consumer Goods & Industrial'), NOW(), NOW(), 1),
       ('Forestry & Logging', (SELECT id FROM sector WHERE sector ='Agriculture, Fishery & Livestock'), NOW(), NOW(), 1),
       ('General Engineering Consultancy', (SELECT id FROM sector WHERE sector ='Engineering & Technical Services'), NOW(), NOW(), 1),
       ('Graphic Design', (SELECT id FROM sector WHERE sector ='Arts, Entertainment & Media'), NOW(), NOW(), 1),
       ('Ground Fleet, Aviation, & Marine Refuelling', (SELECT id FROM sector WHERE sector ='Engineering & Technical Services'), NOW(), NOW(), 1),
       ('Hardware & Building Materials', (SELECT id FROM sector WHERE sector ='Retail & Wholesale'), NOW(), NOW(), 1),
       ('Heavy Industry & Metallurgy', (SELECT id FROM sector WHERE sector ='Manufacturing, Consumer Goods & Industrial'), NOW(), NOW(), 1),
       ('Higher Education', (SELECT id FROM sector WHERE sector ='Education, Science, & Research'), NOW(), NOW(), 1),
       ('Home & Office Furniture', (SELECT id FROM sector WHERE sector ='Retail & Wholesale'), NOW(), NOW(), 1),
       ('Home Accessories & Decor', (SELECT id FROM sector WHERE sector ='Retail & Wholesale'), NOW(), NOW(), 1),
       ('Hospitality & Accomodation', (SELECT id FROM sector WHERE sector ='Leisure, Hospitality & Tourism'), NOW(), NOW(), 1),
       ('Household Appliances', (SELECT id FROM sector WHERE sector ='Retail & Wholesale'), NOW(), NOW(), 1),
       ('Human Resources Outsourcing', (SELECT id FROM sector WHERE sector ='Business Support & Marketing'), NOW(), NOW(), 1),
       ('IT Services', (SELECT id FROM sector WHERE sector ='IT & Telecom'), NOW(), NOW(), 1),
       ('Industrial Engineering & Automation', (SELECT id FROM sector WHERE sector ='Engineering & Technical Services'), NOW(), NOW(), 1),
       ('Industrial Production', (SELECT id FROM sector WHERE sector ='Manufacturing, Consumer Goods & Industrial'), NOW(), NOW(), 1),
       ('Installation & Technical Services', (SELECT id FROM sector WHERE sector ='Engineering & Technical Services'), NOW(), NOW(), 1),
       ('Insurance & TPA', (SELECT id FROM sector WHERE sector ='Finance, Insurance, & Legal'), NOW(), NOW(), 1),
       ('Interior design', (SELECT id FROM sector WHERE sector ='Construction & Property'), NOW(), NOW(), 1),
       ('Internet & E-commerce', (SELECT id FROM sector WHERE sector ='IT & Telecom'), NOW(), NOW(), 1),
       ('Investment, Securities & Funds', (SELECT id FROM sector WHERE sector ='Finance, Insurance, & Legal'), NOW(), NOW(), 1),
       ('Islamic Banking', (SELECT id FROM sector WHERE sector ='Finance, Insurance, & Legal'), NOW(), NOW(), 1),
       ('Jewelry & Gold', (SELECT id FROM sector WHERE sector ='Retail & Wholesale'), NOW(), NOW(), 1),
       ('Journalism', (SELECT id FROM sector WHERE sector ='Arts, Entertainment & Media'), NOW(), NOW(), 1),
       ('Knowledge Process Outsourcing (KPO)', (SELECT id FROM sector WHERE sector ='Business Support & Marketing'), NOW(), NOW(), 1),
       ('LPG Bottling', (SELECT id FROM sector WHERE sector ='Oil, Energy, & Utilities'), NOW(), NOW(), 1),
       ('Laboratory & Quality Control', (SELECT id FROM sector WHERE sector ='Education, Science, & Research'), NOW(), NOW(), 1),
       ('Law Enforcement & Civil Defence', (SELECT id FROM sector WHERE sector ='Security'), NOW(), NOW(), 1),
       ('Law Firm', (SELECT id FROM sector WHERE sector ='Finance, Insurance, & Legal'), NOW(), NOW(), 1),
       ('Legal Process Outsourcing (LPO)', (SELECT id FROM sector WHERE sector ='Business Support & Marketing'), NOW(), NOW(), 1),
       ('Library', (SELECT id FROM sector WHERE sector ='Education, Science, & Research'), NOW(), NOW(), 1),
       ('Livestock', (SELECT id FROM sector WHERE sector ='Agriculture, Fishery & Livestock'), NOW(), NOW(), 1),
       ('Lubricants & Greases Blending', (SELECT id FROM sector WHERE sector ='Manufacturing, Consumer Goods & Industrial'), NOW(), NOW(), 1),
       ('Management Consulting', (SELECT id FROM sector WHERE sector ='Business Support & Marketing'), NOW(), NOW(), 1),
       ('Manufacturing', (SELECT id FROM sector WHERE sector ='Manufacturing, Consumer Goods & Industrial'), NOW(), NOW(), 1),
       ('Marine Transport Services', (SELECT id FROM sector WHERE sector ='Transport, Logistics, & Aviation'), NOW(), NOW(), 1),
       ('Maritime & Marine Engineering', (SELECT id FROM sector WHERE sector ='Engineering & Technical Services'), NOW(), NOW(), 1),
       ('Market Research', (SELECT id FROM sector WHERE sector ='Business Support & Marketing'), NOW(), NOW(), 1),
       ('Marketing', (SELECT id FROM sector WHERE sector ='Business Support & Marketing'), NOW(), NOW(), 1),
       ('Mechanical Engineering', (SELECT id FROM sector WHERE sector ='Engineering & Technical Services'), NOW(), NOW(), 1),
       ('Media Production', (SELECT id FROM sector WHERE sector ='Arts, Entertainment & Media'), NOW(), NOW(), 1),
       ('Medical & Healthcare Equipment', (SELECT id FROM sector WHERE sector ='Healthcare & Pharma'), NOW(), NOW(), 1),
       ('Medical Clinic', (SELECT id FROM sector WHERE sector ='Healthcare & Pharma'), NOW(), NOW(), 1),
       ('Medical Hospital', (SELECT id FROM sector WHERE sector ='Healthcare & Pharma'), NOW(), NOW(), 1),
       ('Merchandising', (SELECT id FROM sector WHERE sector ='Business Support & Marketing'), NOW(), NOW(), 1),
       ('Metro & Rail Passenger Transport', (SELECT id FROM sector WHERE sector ='Transport, Logistics, & Aviation'), NOW(), NOW(), 1),
       ('Military & Defense', (SELECT id FROM sector WHERE sector ='Military & Aerospace'), NOW(), NOW(), 1),
       ('Mining & Quarrying', (SELECT id FROM sector WHERE sector ='Oil, Energy, & Utilities'), NOW(), NOW(), 1),
       ('Modeling & Talent Agency', (SELECT id FROM sector WHERE sector ='Arts, Entertainment & Media'), NOW(), NOW(), 1),
       ('Motor Vehicle Passenger Transport', (SELECT id FROM sector WHERE sector ='Transport, Logistics, & Aviation'), NOW(), NOW(), 1),
       ('Music Production', (SELECT id FROM sector WHERE sector ='Arts, Entertainment & Media'), NOW(), NOW(), 1),
       ('Natural Gas Distribution', (SELECT id FROM sector WHERE sector ='Oil, Energy, & Utilities'), NOW(), NOW(), 1),
       ('Non-profit Organization', (SELECT id FROM sector WHERE sector ='Government, Community, & NGO'), NOW(), NOW(), 1),
       ('Office Supplies', (SELECT id FROM sector WHERE sector ='Retail & Wholesale'), NOW(), NOW(), 1),
       ('Oil & Gas', (SELECT id FROM sector WHERE sector ='Oil, Energy, & Utilities'), NOW(), NOW(), 1),
       ('Other Business Support Services', (SELECT id FROM sector WHERE sector ='Business Support & Marketing'), NOW(), NOW(), 1),
       ('Other Healthcare Services', (SELECT id FROM sector WHERE sector ='Healthcare & Pharma'), NOW(), NOW(), 1),
       ('Paper & Paper Product Manufacture', (SELECT id FROM sector WHERE sector ='Manufacturing, Consumer Goods & Industrial'), NOW(), NOW(), 1),
       ('Performing Arts', (SELECT id FROM sector WHERE sector ='Arts, Entertainment & Media'), NOW(), NOW(), 1),
       ('Perfume & Cosmetics', (SELECT id FROM sector WHERE sector ='Retail & Wholesale'), NOW(), NOW(), 1),
       ('Personal Care Centers', (SELECT id FROM sector WHERE sector ='Personal Services & Wellness'), NOW(), NOW(), 1),
       ('Personal Services', (SELECT id FROM sector WHERE sector ='Personal Services & Wellness'), NOW(), NOW(), 1),
       ('Pet Supplies', (SELECT id FROM sector WHERE sector ='Retail & Wholesale'), NOW(), NOW(), 1),
       ('Petrochemicals & Refined Petroleum Products Manufacture', (SELECT id FROM sector WHERE sector ='Manufacturing, Consumer Goods & Industrial'), NOW(), NOW(), 1),
       ('Pharmaceutical', (SELECT id FROM sector WHERE sector ='Healthcare & Pharma'), NOW(), NOW(), 1),
       ('Photography', (SELECT id FROM sector WHERE sector ='Arts, Entertainment & Media'), NOW(), NOW(), 1),
       ('Plants & Gardening Equipment', (SELECT id FROM sector WHERE sector ='Retail & Wholesale'), NOW(), NOW(), 1),
       ('Preschool, Nursery, & Daycare', (SELECT id FROM sector WHERE sector ='Education, Science, & Research'), NOW(), NOW(), 1),
       ('Primary, Prep, & Secondary School', (SELECT id FROM sector WHERE sector ='Education, Science, & Research'), NOW(), NOW(), 1),
       ('Private Security Services', (SELECT id FROM sector WHERE sector ='Security'), NOW(), NOW(), 1),
       ('Project & Construction Planning', (SELECT id FROM sector WHERE sector ='Engineering & Technical Services'), NOW(), NOW(), 1),
       ('Public Administration', (SELECT id FROM sector WHERE sector ='Government, Community, & NGO'), NOW(), NOW(), 1),
       ('Public Relations (PR)', (SELECT id FROM sector WHERE sector ='Business Support & Marketing'), NOW(), NOW(), 1),
       ('Publishing', (SELECT id FROM sector WHERE sector ='Arts, Entertainment & Media'), NOW(), NOW(), 1),
       ('Purchasing & Procurement', (SELECT id FROM sector WHERE sector ='Transport, Logistics, & Aviation'), NOW(), NOW(), 1),
       ('Quantity Survey', (SELECT id FROM sector WHERE sector ='Engineering & Technical Services'), NOW(), NOW(), 1),
       ('Real Estate', (SELECT id FROM sector WHERE sector ='Construction & Property'), NOW(), NOW(), 1),
       ('Recruitment & Employee Placement Agency', (SELECT id FROM sector WHERE sector ='Business Support & Marketing'), NOW(), NOW(), 1),
       ('Religious Institution & Place of Worship', (SELECT id FROM sector WHERE sector ='Government, Community, & NGO'), NOW(), NOW(), 1),
       ('Residential & Nursing Care Services', (SELECT id FROM sector WHERE sector ='Healthcare & Pharma'), NOW(), NOW(), 1),
       ('Safety & Environment', (SELECT id FROM sector WHERE sector ='Engineering & Technical Services'), NOW(), NOW(), 1),
       ('Sales Outsourcing', (SELECT id FROM sector WHERE sector ='Business Support & Marketing'), NOW(), NOW(), 1),
       ('Scientific Research & Development', (SELECT id FROM sector WHERE sector ='Education, Science, & Research'), NOW(), NOW(), 1),
       ('Security & Fire Systems', (SELECT id FROM sector WHERE sector ='Security'), NOW(), NOW(), 1),
       ('Semiconductors', (SELECT id FROM sector WHERE sector ='Manufacturing, Consumer Goods & Industrial'), NOW(), NOW(), 1),
       ('Shipping', (SELECT id FROM sector WHERE sector ='Transport, Logistics, & Aviation'), NOW(), NOW(), 1),
       ('Social Services', (SELECT id FROM sector WHERE sector ='Government, Community, & NGO'), NOW(), NOW(), 1),
       ('Software Development', (SELECT id FROM sector WHERE sector ='IT & Telecom'), NOW(), NOW(), 1),
       ('Sporting Goods', (SELECT id FROM sector WHERE sector ='Retail & Wholesale'), NOW(), NOW(), 1),
       ('Sports & Outdoor Activities', (SELECT id FROM sector WHERE sector ='Leisure, Hospitality & Tourism'), NOW(), NOW(), 1),
       ('Supermarket', (SELECT id FROM sector WHERE sector ='Retail & Wholesale'), NOW(), NOW(), 1),
       ('Technical Maintenance & Repair', (SELECT id FROM sector WHERE sector ='Engineering & Technical Services'), NOW(), NOW(), 1),
       ('Telecommunications', (SELECT id FROM sector WHERE sector ='IT & Telecom'), NOW(), NOW(), 1),
       ('Telemarketing', (SELECT id FROM sector WHERE sector ='Business Support & Marketing'), NOW(), NOW(), 1),
       ('Textile & Apparel Production', (SELECT id FROM sector WHERE sector ='Manufacturing, Consumer Goods & Industrial'), NOW(), NOW(), 1),
       ('Tobacco & Smoking Goods', (SELECT id FROM sector WHERE sector ='Retail & Wholesale'), NOW(), NOW(), 1),
       ('Tobacco Products Manufacture', (SELECT id FROM sector WHERE sector ='Manufacturing, Consumer Goods & Industrial'), NOW(), NOW(), 1),
       ('Tourism, Museum, & Cultural', (SELECT id FROM sector WHERE sector ='Leisure, Hospitality & Tourism'), NOW(), NOW(), 1),
       ('Toys & Leisure', (SELECT id FROM sector WHERE sector ='Retail & Wholesale'), NOW(), NOW(), 1),
       ('Trading & Commodity Trading', (SELECT id FROM sector WHERE sector ='Retail & Wholesale'), NOW(), NOW(), 1),
       ('Training & Education Center', (SELECT id FROM sector WHERE sector ='Education, Science, & Research'), NOW(), NOW(), 1),
       ('Translation & Document Processing', (SELECT id FROM sector WHERE sector ='Business Support & Marketing'), NOW(), NOW(), 1),
       ('Travel Agency', (SELECT id FROM sector WHERE sector ='Leisure, Hospitality & Tourism'), NOW(), NOW(), 1),
       ('Utilities', (SELECT id FROM sector WHERE sector ='Oil, Energy, & Utilities'), NOW(), NOW(), 1),
       ('Venture Capital & Private Equity', (SELECT id FROM sector WHERE sector ='Finance, Insurance, & Legal'), NOW(), NOW(), 1),
       ('Veterinary Hospital & Clinic', (SELECT id FROM sector WHERE sector ='Healthcare & Pharma'), NOW(), NOW(), 1),
       ('Video & Film Production', (SELECT id FROM sector WHERE sector ='Arts, Entertainment & Media'), NOW(), NOW(), 1),
       ('Video Gaming', (SELECT id FROM sector WHERE sector ='IT & Telecom'), NOW(), NOW(), 1),
       ('Virtual Assistant Services', (SELECT id FROM sector WHERE sector ='Business Support & Marketing'), NOW(), NOW(), 1),
       ('Vocational Education', (SELECT id FROM sector WHERE sector ='Education, Science, & Research'), NOW(), NOW(), 1),
       ('Warehousing', (SELECT id FROM sector WHERE sector ='Transport, Logistics, & Aviation'), NOW(), NOW(), 1),
       ('Waste Disposal & Recycling', (SELECT id FROM sector WHERE sector ='Oil, Energy, & Utilities'), NOW(), NOW(), 1),
       ('Watches & Luxury Goods', (SELECT id FROM sector WHERE sector ='Retail & Wholesale'), NOW(), NOW(), 1),
       ('Water & Waste Water Treatment', (SELECT id FROM sector WHERE sector ='Oil, Energy, & Utilities'), NOW(), NOW(), 1),
       ('Wholesale & Import/Export Trade', (SELECT id FROM sector WHERE sector ='Retail & Wholesale'), NOW(), NOW(), 1);
