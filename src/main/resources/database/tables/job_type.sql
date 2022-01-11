CREATE TABLE job_type
(
    id                  	BIGSERIAL,
    job_type                VARCHAR(256),
    created_on           	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_on           	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by           	BIGINT,
    updated_by           	BIGINT,

    CONSTRAINT pk_job_type PRIMARY KEY (id)
);
