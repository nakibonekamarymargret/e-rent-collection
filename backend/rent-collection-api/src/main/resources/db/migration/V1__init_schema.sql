CREATE TABLE users(
    id SERIAL PRIMARY KEY ,
    full_name VARCHAR(150) NOT NULL,
    phone varchar(20) UNIQUE ,
    email varchar(150) UNIQUE ,
    username VARCHAR(100) UNIQUE  NOT NULL ,
    password VARCHAR(255) NOT NULL ,
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT  CURRENT_TIMESTAMP
);

CREATE TABLE roles(
    id SERIAL PRIMARY KEY ,
    name VARCHAR(50) UNIQUE  NOT NULL
);

CREATE TABLE user_roles
(
    user_id INT REFERENCES users (id) ON DELETE CASCADE,
    role_id INT REFERENCES roles (id) ON DELETE CASCADE,
    PRIMARY KEY (user_id, role_id)
);

