CREATE TABLE company_industry
(
    id                  	BIGSERIAL,
    company_industry        VARCHAR(256),
    sector_id               BIGINT NOT NULL REFERENCES sector (id),
    created_on           	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_on           	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by           	BIGINT,

    CONSTRAINT pk_company_industry PRIMARY KEY (id)
);
