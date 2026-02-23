CREATE TABLE receipts (
                          id SERIAL PRIMARY KEY,
                          payment_id INT NOT NULL UNIQUE REFERENCES payments(id) ON DELETE CASCADE,
                          receipt_number VARCHAR(100) UNIQUE NOT NULL,  -- RCPT-00001
                          issued_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


