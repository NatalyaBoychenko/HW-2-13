CREATE TABLE client (
                        id IDENTITY PRIMARY KEY,
                        name VARCHAR(200) CHECK(char_length(name) >= 3) NOT NULL
);

CREATE TABLE planet (
                        id VARCHAR PRIMARY KEY CHECK (id = UPPER(id)),
                        name VARCHAR(500) CHECK(char_length(name) >= 1)
);

CREATE TABLE ticket (
                        id IDENTITY PRIMARY KEY,
                        created_at TIMESTAMP NOT NULL,
                        client_id BIGINT NOT NULL,
                        from_planet_id VARCHAR(500) NOT NULL,
                        to_planet_id VARCHAR(500) NOT NULL,
                        FOREIGN KEY (client_id) REFERENCES client(id),
                        FOREIGN KEY (from_planet_id) REFERENCES planet(id),
                        FOREIGN KEY (to_planet_id) REFERENCES planet(id)
);