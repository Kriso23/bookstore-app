CREATE TABLE IF NOT EXISTS Author(
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    birthday TIMESTAMP
);

CREATE TABLE IF NOT EXISTS Book (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255),
    descr VARCHAR(255),
    author INTEGER,
    price INTEGER,

    CONSTRAINT fk_author FOREIGN KEY (author) REFERENCES Author(id)
);
