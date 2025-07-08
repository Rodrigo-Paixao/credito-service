
INSERT INTO credito (
    numero_credito, numero_nfse, data_constituicao, valor_issqn, tipo_credito,
    simples_nacional, aliquota, valor_faturado, valor_deducao, base_calculo
) VALUES
('123456', '7891011', '2024-02-25', 1500.75, 'ISSQN', true, 5.0, 30000.00, 5000.00, 25000.00),
('789012', '7891011', '2024-02-26', 1200.50, 'ISSQN', false, 4.5, 25000.00, 4000.00, 21000.00),
('654321', '1122334', '2024-01-15', 800.50, 'Outros', true, 3.5, 20000.00, 3000.00, 17000.00),

-- Três exemplos adicionais
('321654', '111222', '2024-01-10', 1000.00, 'ISSQN', true, 3.5, 15000.00, 2000.00, 13000.00),
('987654', '333444', '2024-02-20', 2500.00, 'ISSQN', false, 5.0, 50000.00, 5000.00, 45000.00),
('963852', '555666', '2024-03-05', 1800.00, 'ISSQN', true, 4.0, 20000.00, 3000.00, 17000.00);
