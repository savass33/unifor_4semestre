drop table funcionario;

CREATE TABLE FUNCIONARIO (
    id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nome VARCHAR(30),
    cargo VARCHAR(20),
    idade INT,
    sexo ENUM('H','M'),
    telefone VARCHAR(20),
    estado ENUM('Ativo','Inativo')
);

INSERT INTO FUNCIONARIO (nome, cargo, idade, sexo, telefone, estado) VALUES
('João Silva', 'Tratador', 35, 'H', '(85) 99999-1234', 'Ativo'),
('Maria Oliveira', 'Veterinária', 42, 'M', '(85) 98888-5678', 'Ativo'),
('Carlos Pereira', 'Gerente', 50, 'H', '(85) 97777-4321', 'Ativo'),
('Ana Souza', 'Bióloga', 28, 'M', '(85) 96666-8765', 'Ativo'),
('Pedro Costa', 'Veterinário', 55, 'H', '(85) 95555-1122', 'Inativo');

-- Desabilitar modos seguros
SET SQL_SAFE_UPDATES = 0;
SET GLOBAL sql_mode='';

-- Adicionar coluna cpf
ALTER TABLE FUNCIONARIO ADD COLUMN CPF VARCHAR(11);

-- cpfs temporários com base no id
UPDATE FUNCIONARIO SET CPF = id;

-- Remove auto da coluna antiga
ALTER TABLE FUNCIONARIO MODIFY COLUMN id INT NOT NULL;

-- Dropa a pk antiga
ALTER TABLE FUNCIONARIO DROP PRIMARY KEY;

-- seta CPF como NOT NULL e define como a nova PK
ALTER TABLE FUNCIONARIO MODIFY COLUMN CPF VARCHAR(11) NOT NULL;
ALTER TABLE FUNCIONARIO ADD PRIMARY KEY (CPF);

SELECT * FROM FUNCIONARIO;