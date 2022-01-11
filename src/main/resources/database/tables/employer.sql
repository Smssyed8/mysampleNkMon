CREATE TABLE employer
(
    id                  	    BIGSERIAL,
    account_id          	    BIGINT NOT NULL REFERENCES account (id),
    designation         	    VARCHAR(256),
    company_name        	    VARCHAR(256) NOT NULL,
    sector                      BIGINT NULL REFERENCES sector (id),
    company_industry            BIGINT NULL REFERENCES company_industry (id),
    company_type                BIGINT NULL REFERENCES company_type (id),
    tax_registration_number     INTEGER DEFAULT 0,
    current_job_posting_count   INTEGER DEFAULT 0,
    current_cv_search_count     INTEGER DEFAULT 0,
    image_path          	    VARCHAR(256),
    crn_number          	    VARCHAR(256),
    package_id          	    BIGINT NULL REFERENCES packages (id),
    address          	        VARCHAR(256),
    created_on          	    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_on          	    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by          	    BIGINT,
 
    CONSTRAINT pk_employer PRIMARY KEY (id)
);
