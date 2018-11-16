/*todo: constraint to makesure screening times dont overlap*/

CREATE TABLE THEATRE (
    THEATRE_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    THEATRE_NAME VARCHAR(50) NOT NULL,
    THEATRE_CITY VARCHAR(20) NOT NULL
);

CREATE TABLE SCREEN (
    SCREEN_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    THEATRE_ID BIGINT NOT NULL REFERENCES THEATRE (THEATRE_ID),
    SEATS_NUM INTEGER NOT NULL
);

CREATE TABLE MOVIE (
    MOVIE_ID INTEGER PRIMARY KEY,
    MOVIE_NAME VARCHAR(50),
    MOVIE_POSTER_URL VARCHAR(500),
    MOVIE_TAGS VARCHAR(100)
);

CREATE TABLE SCREENING (
    SCREENING_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    THEATRE_ID BIGINT NOT NULL REFERENCES THEATRE (THEATRE_ID),
    SCREEN_ID BIGINT NOT NULL REFERENCES SCREEN (SCREEN_ID),
    MOVIE_NAME VARCHAR(50) NOT NULL REFERENCES MOVIE (MOVIE_NAME),
    SCREENING_DATE DATE NOT NULL,
    SCREENING_TIME TIME NOT NULL,
    BOOKED_TICKETS INTEGER NOT NULL,
    CONSTRAINT UNIQUE_SCREENING UNIQUE(THEATRE_ID, SCREEN_ID, SCREENING_DATE, SCREENING_TIME)
);

CREATE TABLE TICKET (
    TICKET_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    SCREENING_ID BIGINT NOT NULL REFERENCES SCREENING (SCREENING_ID),
    SEAT_NUM INTEGER NOT NULL,
);

CREATE TABLE SEAT (
    SEAT_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    ROW_ID CHAR(1) NOT NULL,
    ROW_NUMBER INTEGER NOT NULL,
    SCREEN_ID BIGINT,
    CONSTRAINT SEAT_FK FOREIGN KEY (SCREEN_ID) REFERENCES SCREEN (SCREEN_ID)
);