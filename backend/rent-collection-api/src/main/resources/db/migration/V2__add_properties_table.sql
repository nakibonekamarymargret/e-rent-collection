CREATE TABLE properties(
    id SERIAL PRIMARY KEY ,
    name VARCHAR(150) NOT NULL,
    location VARCHAR(200),
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE rooms (
                       id SERIAL PRIMARY KEY,
                       property_id INT REFERENCES properties(id),
                       room_number VARCHAR(50),
                       monthly_rent DECIMAL(10,2) NOT NULL,
                       status VARCHAR(20) DEFAULT 'VACANT'
);
