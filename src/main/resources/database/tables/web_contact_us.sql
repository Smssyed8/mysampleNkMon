CREATE TABLE web_contact_us
(
    id         BIGSERIAL,
    name       VARCHAR(256),
    email      VARCHAR(256),
    message    TEXT,
    created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT pk_web_contact_us PRIMARY KEY (id)
);