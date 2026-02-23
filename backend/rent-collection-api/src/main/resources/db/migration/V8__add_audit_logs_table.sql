CREATE TABLE audit_logs (
                        id SERIAL PRIMARY KEY,
                        user_id INT NOT NULL REFERENCES users(id) ON DELETE SET NULL ,
                        action VARCHAR(100) ,
                        entity VARCHAR(100),
                        entity_id INT,

                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


