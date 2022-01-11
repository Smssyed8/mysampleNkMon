CREATE TABLE job
(
    id                  	    BIGSERIAL,
    employer_id         	    BIGINT NOT NULL REFERENCES employer (id),
    job_title           	    VARCHAR(256) NOT NULL,
    job_role  	                BIGINT NOT NULL REFERENCES job_role (id),
    city_id    		    	    BIGINT NOT NULL REFERENCES city (id),
    job_level           	    BIGINT NOT NULL REFERENCES job_level (id),
    job_type           	        BIGINT NOT NULL REFERENCES job_type (id),
    company_industry            BIGINT NOT NULL REFERENCES company_industry (id),
    type_of_work        	    VARCHAR(256) NOT NULL,
    monthly_salary      	    BIGINT NOT NULL,
    professional_summary 	    VARCHAR(256) NOT NULL,
    notice_period       	    SMALLINT DEFAULT 0,
    years_of_experience 	    SMALLINT DEFAULT 0,
    skills              	    VARCHAR(256) NOT NULL,
    description         	    VARCHAR(256) NOT NULL,
    last_date_for_application 	TIMESTAMP,
    min_salary           	    BIGINT,
    max_salary           	    BIGINT,
    qualification        	    VARCHAR(256) NOT NULL,
    required_gender        	    VARCHAR(16) NOT NULL,
    created_on           	    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_on           	    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by           	    BIGINT,

    CONSTRAINT pk_job PRIMARY KEY (id)
);
