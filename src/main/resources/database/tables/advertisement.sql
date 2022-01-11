CREATE TABLE advertisement
(
    id                  	BIGSERIAL,
    title          	        VARCHAR(256),
    text         	        VARCHAR(256),
    button_text        	    VARCHAR(256) NOT NULL,
    link                    VARCHAR(256),
    image_path              VARCHAR(256),
    show                    BOOLEAN DEFAULT FALSE,
    price                   DOUBLE PRECISION DEFAULT 0,
    payment_done            BOOLEAN DEFAULT FALSE,
    created_on          	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_on          	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by          	BIGINT,
 
    CONSTRAINT pk_advertisement PRIMARY KEY (id)
);