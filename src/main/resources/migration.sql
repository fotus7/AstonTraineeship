CREATE TABLE actors
(
    id            SERIAL PRIMARY KEY,
    name          VARCHAR(100) UNIQUE NOT NULL,
    date_of_birth DATE                NOT NULL,
    num_of_oscars SMALLINT            NOT NULL
);

CREATE TABLE directors
(
    id            SERIAL PRIMARY KEY,
    name          VARCHAR(100) UNIQUE NOT NULL,
    date_of_birth DATE                NOT NULL,
    num_of_movies SMALLINT            NOT NULL
);

CREATE TABLE movies
(
    id           SERIAL PRIMARY KEY,
    director_id  INT                 NOT NULL,
    name         VARCHAR(100) UNIQUE NOT NULL,
    genre        VARCHAR(50),
    release_date DATE                NOT NULL,
    money_made   SMALLINT            NOT NULL,
    CONSTRAINT fk_director
        FOREIGN KEY (director_id)
            REFERENCES directors (id)
);

CREATE TABLE actors_movies
(
    id       SERIAL PRIMARY KEY,
    actor_id INT NOT NULL
        CONSTRAINT fk_actor
            REFERENCES actors,
    movie_id INT NOT NULL
        CONSTRAINT fk_movie
            REFERENCES movies
);