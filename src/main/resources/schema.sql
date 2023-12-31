CREATE TABLE PERSON(
    ID BIGINT NOT NULL AUTO_INCREMENT,
    FIRST_NAME VARCHAR(255) NOT NULL,
    LAST_NAME VARCHAR(255) NOT NULL,
    AGE INTEGER NOT NULL,
    EMAIL VARCHAR(255) NOT NULL,
    PASSWORD VARCHAR(255) NOT NULL,
    PRIMARY KEY(ID)
);

CREATE TABLE AUTHENTICATOR(
    ID BIGINT NOT NULL AUTO_INCREMENT,
    TOKEN VARCHAR(255) NOT NULL,
    EXPIRATION BIGINT,
    PRIMARY KEY(ID)
);