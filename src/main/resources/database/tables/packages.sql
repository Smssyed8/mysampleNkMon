CREATE TABLE packages
(
    id                  	    BIGSERIAL,
    package_name			    VARCHAR(256) NOT NULL,
    package_description		    VARCHAR(256) NOT NULL,
    price			            DOUBLE PRECISION,
    selling_price			    DOUBLE PRECISION,
    cv_search_limit     	    INTEGER DEFAULT 0,
    job_posting_limit   	    INTEGER DEFAULT 0,
    is_unlimited_cv_search      BOOLEAN DEFAULT false,
    is_unlimited_job_posting    BOOLEAN DEFAULT false,
    duration_in_month           INTEGER DEFAULT 0,
    created_on           	    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_on           	    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT pk_packages PRIMARY KEY (id)
);
