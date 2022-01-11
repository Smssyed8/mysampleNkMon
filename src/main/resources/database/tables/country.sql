CREATE TABLE country
(
    id                  	BIGSERIAL,
    country                	VARCHAR(256),
    path                    	VARCHAR(256),
    created_on           	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_on           	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by           	BIGINT,

    CONSTRAINT pk_country PRIMARY KEY (id)
);
