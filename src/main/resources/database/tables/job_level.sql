CREATE TABLE job_level
(
    id                  	BIGSERIAL,
    job_level               VARCHAR(256),
    created_on           	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_on           	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by           	BIGINT,
    updated_by           	BIGINT,

    CONSTRAINT pk_job_level PRIMARY KEY (id)
);
