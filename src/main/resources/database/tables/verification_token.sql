CREATE TABLE verification_token
(
    id                  	BIGSERIAL,
    verification_token      VARCHAR(256),
    account_id           	BIGINT NOT NULL REFERENCES account (id),
    created_on           	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT pk_verification_token PRIMARY KEY (id)
);
