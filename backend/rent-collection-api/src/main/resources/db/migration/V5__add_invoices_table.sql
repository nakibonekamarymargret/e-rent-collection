CREATE TABLE invoices (
                          id SERIAL PRIMARY KEY,
                          lease_id INT NOT NULL REFERENCES leases(id) ON DELETE CASCADE,
                          invoice_month DATE NOT NULL,  -- 2026-02-01 format
                          due_date DATE NOT NULL,
                          amount_due NUMERIC(12,2) NOT NULL,
                          status VARCHAR(20) DEFAULT 'PENDING',
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          UNIQUE (lease_id, invoice_month)
);


