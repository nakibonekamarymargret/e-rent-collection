CREATE TABLE payments (
                          id SERIAL PRIMARY KEY,
                          invoice_id INT NOT NULL REFERENCES invoices(id) ON DELETE CASCADE,
                          collected_by INT REFERENCES users(id) ON DELETE SET NULL,
                          amount_paid NUMERIC(12,2) NOT NULL,
                          payment_method VARCHAR(50) NOT NULL,   -- CASH, MOMO, BANK
                          transaction_reference VARCHAR(100),
                          payment_date DATE NOT NULL,
                          notes TEXT,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

