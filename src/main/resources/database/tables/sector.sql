CREATE TABLE sector
(
    id                  	BIGSERIAL,
    sector                  VARCHAR(256),
    created_on           	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_on           	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by           	BIGINT,

    CONSTRAINT pk_sector PRIMARY KEY (id)
);
