CREATE TABLE education
(
    id                  BIGSERIAL,
    jobseeker_id        BIGINT NOT NULL REFERENCES jobseeker (id),
    level           	VARCHAR(256) NOT NULL,
    institution_name  	VARCHAR(256) NOT NULL,
    field_of_study      VARCHAR(256) NOT NULL,
    city_id           	BIGINT NOT NULL REFERENCES city (id),
    date_of_completion	TIMESTAMP NOT NULL,
    percentage      	DOUBLE PRECISION,
    grade 		        VARCHAR(5),
    certificate         VARCHAR(256) NOT NULL,
    description         VARCHAR(256) NOT NULL,
    created_on          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_on          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by          BIGINT,

    CONSTRAINT pk_education PRIMARY KEY (id)
);
