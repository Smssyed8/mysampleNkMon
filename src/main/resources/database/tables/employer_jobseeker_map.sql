CREATE TABLE employer_jobseeker_map
(
    id                  	BIGSERIAL,
    employer_id         	BIGINT NOT NULL REFERENCES employer (id),
    jobseeker_id         	BIGINT NOT NULL REFERENCES jobseeker (id),
    created_on           	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_on           	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT pk_employer_jobseeker_map PRIMARY KEY (id)
);
