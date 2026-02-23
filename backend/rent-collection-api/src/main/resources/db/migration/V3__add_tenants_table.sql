CREATE TABLE tenants (
                         id SERIAL PRIMARY KEY,
                         tenant_code VARCHAR(50) UNIQUE,
                         full_name VARCHAR(150),
                         phone VARCHAR(20),
                         national_id VARCHAR(50),
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);