-- Track the updates applied to the JobPortal database

CREATE TABLE version
(
    id         BIGSERIAL,
    major      SMALLINT,
    minor      SMALLINT,
    patch      SMALLINT,
    created_on TIMESTAMP DEFAULT NOW(),

    CONSTRAINT pk_version PRIMARY KEY (id)
);

GRANT ALL PRIVILEGES ON version TO mf;
GRANT ALL PRIVILEGES ON version_id_seq TO mf;
