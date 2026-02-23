CREATE TABLE leases (
                        id SERIAL PRIMARY KEY,
                        tenant_id INT NOT NULL REFERENCES tenants(id) ON DELETE CASCADE,
                        room_id INT NOT NULL REFERENCES rooms(id) ON DELETE CASCADE,
                        start_date DATE NOT NULL,
                        end_date DATE,
                        rent_amount NUMERIC(12,2) NOT NULL,
                        status VARCHAR(50) DEFAULT 'ACTIVE',
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
