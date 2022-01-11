CREATE TABLE jobseeker_job_map
(
    id                  BIGSERIAL,
    jobseeker_id        BIGINT NOT NULL REFERENCES jobseeker (id),
    job_id         		BIGINT NOT NULL REFERENCES job (id),
    shortlisted         BOOLEAN DEFAULT false,
    created_on          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    UNIQUE (jobseeker_id, job_id),

    CONSTRAINT pk_jobseeker_job_map PRIMARY KEY (id)
);
