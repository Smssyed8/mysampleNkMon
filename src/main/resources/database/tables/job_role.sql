CREATE TABLE job_role
(
    id                  	BIGSERIAL,
    job_role                VARCHAR(256),
    created_on           	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_on           	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by           	BIGINT,

    CONSTRAINT pk_job_role PRIMARY KEY (id)
);
