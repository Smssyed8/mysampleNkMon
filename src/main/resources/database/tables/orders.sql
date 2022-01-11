CREATE TABLE orders
(
    id                  	BIGSERIAL,
    package_id              BIGINT NOT NULL REFERENCES packages (id),
    employer_id             BIGINT NOT NULL REFERENCES employer (id),
    amount           	    DOUBLE PRECISION,
    discount           	    DOUBLE PRECISION,
    order_status            VARCHAR(25),
    ordered_on           	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ordered_by           	BIGINT,

    CONSTRAINT pk_order PRIMARY KEY (id)
);
