CREATE TABLE employer_contact_us
(
    id              BIGSERIAL,
    subject         VARCHAR(256),
    name            VARCHAR(256),
    email           VARCHAR(256),
    message         TEXT,
    job_title       VARCHAR(256),
    company_name    VARCHAR(256),
    country_id      BIGINT NOT NULL REFERENCES country (id),
    mobile_number   VARCHAR(256),
    employer_id     BIGINT NOT NULL REFERENCES employer (id),
    created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT pk_employer_contact_us PRIMARY KEY (id)
);