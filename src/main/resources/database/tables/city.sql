CREATE TABLE city
(
    id                  	BIGSERIAL,
    city                	VARCHAR(256),
    path                    	VARCHAR(256),
    country_id           	BIGINT NOT NULL REFERENCES country (id),
    created_on           	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_on           	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by           	BIGINT,

    CONSTRAINT pk_city PRIMARY KEY (id)
);
