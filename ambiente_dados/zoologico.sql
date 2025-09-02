CREATE TABLE ESPECIE(
	id int PRIMARY KEY,
    nome_comum VARCHAR(30) NOT NULL,
    nome_cientifico VARCHAR(70) NOT NULL,
	familia VARCHAR(50)
);

CREATE TABLE ANIMAL (
	id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    especie int, # ID da especie
	bioma VARCHAR(30),
    nome VARCHAR(30),
    sexo enum('H','M'),
    data_nasc DATETIME
);

CREATE TABLE HABITATS (
	id int PRIMARY KEY,
	nome VARCHAR(30),
    bioma VARCHAR(30),
    tamanho DECIMAL(10,2),
    cap_max INT,
    ultima_manutencao DATETIME
);

drop table funcionario;

CREATE TABLE FUNCIONARIO (
	id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
	nome VARCHAR(30),
	cargo VARCHAR(20),
    idade INT,
	sexo enum('H','M'),
	telefone VARCHAR(20),
    estado enum('Ativo','Inativo')
);

CREATE TABLE REG_MEDICOS (
	id INT PRIMARY KEY,
	animal int, # ID do animal
    veterinario int, #ID do Funcionario
    data_registro DATETIME,
    tipo_registro VARCHAR(100),
    diagnostico VARCHAR(100),
    tratamento_prescrito VARCHAR(100),
    observacoes VARCHAR(100)
);

-- Inserindo dados na tabela ESPECIE
INSERT INTO ESPECIE (id, nome_comum, nome_cientifico, familia) VALUES
(1, 'Leão', 'Panthera leo', 'Felidae'),
(2, 'Elefante Africano', 'Loxodonta africana', 'Elephantidae'),
(3, 'Girafa', 'Giraffa camelopardalis', 'Giraffidae'),
(4, 'Pinguim-imperador', 'Aptenodytes forsteri', 'Spheniscidae'),
(5, 'Tigre de Bengala', 'Panthera tigris tigris', 'Felidae');

-- Inserindo dados na tabela HABITATS
INSERT INTO HABITATS (id, nome, bioma, tamanho, cap_max, ultima_manutencao) VALUES
(1, 'Recinto dos Felinos', 'Savana', 1200.50, 10, '2025-08-15 09:00:00'),
(2, 'Planície dos Elefantes', 'Savana', 5000.00, 5, '2025-07-30 08:30:00'),
(3, 'Clareira das Girafas', 'Savana', 2500.75, 8, '2025-08-20 11:00:00'),
(4, 'Habitat Gelado', 'Antártida', 800.00, 20, '2025-08-01 14:00:00');

-- Inserindo dados na tabela FUNCIONARIO
INSERT INTO FUNCIONARIO (nome, cargo, idade, sexo, telefone, estado) VALUES
('João Silva', 'Tratador', 35, 'H', '(85) 99999-1234', 'Ativo'),
('Maria Oliveira', 'Veterinária', 42, 'M', '(85) 98888-5678', 'Ativo'),
('Carlos Pereira', 'Gerente', 50, 'H', '(85) 97777-4321', 'Ativo'),
('Ana Souza', 'Bióloga', 28, 'M', '(85) 96666-8765', 'Ativo'),
('Pedro Costa', 'Veterinário', 55, 'H', '(85) 95555-1122', 'Inativo');

-- Inserindo dados na tabela ANIMAL
INSERT INTO ANIMAL (especie, bioma, nome, sexo, data_nasc) VALUES
(1, 'Savana', 'Simba', 'H', '2020-08-28 10:00:00'),
(1, 'Savana', 'Nala', 'M', '2018-07-15 14:30:00'),
(2, 'Savana', 'Dumbo', 'H', '2010-01-20 05:00:00'),
(3, 'Savana', 'Melman', 'H', '2015-05-10 18:00:00'),
(4, 'Antártida', 'Pingu', 'H', '2022-11-30 22:15:00'),
(5, 'Floresta Tropical', 'Rajah', 'H', '2017-03-05 12:00:00');

-- Inserindo dados na tabela REG_MEDICOS
-- Relaciona os animais com os funcionários (veterinários)
INSERT INTO REG_MEDICOS (id, animal, veterinario, data_registro, tipo_registro, diagnostico, tratamento_prescrito, observacoes) VALUES
(1, 1, 2, '2025-06-10 10:30:00', 'Check-up Anual', 'Saudável', 'Nenhum', 'Animal ativo e com peso ideal.'),
(2, 3, 2, '2025-07-22 15:00:00', 'Emergência', 'Infecção de pele', 'Antibióticos e pomada tópica', 'Apresentou melhora após 3 dias de tratamento.'),
(3, 5, 2, '2025-08-05 11:45:00', 'Vacinação', 'N/A', 'Vacina polivalente V10', 'Sem reações adversas à vacina.'),
(4, 6, 5, '2024-11-20 09:00:00', 'Consulta', 'Dor na pata dianteira', 'Anti-inflamatório por 7 dias', 'Registro antigo, veterinário agora inativo.');

-- Q1 - Usar o altertable para adicao de uma nova coluna NN
	ALTER TABLE ANIMAL ADD peso INT NOT NULL;
    select * from animal;
    UPDATE ANIMAL SET peso = 70 WHERE id = 1;

-- Q2 - Usar o altertable para retirar a PK de um atributo (sem excluir o atributo) e adicionar uma nova coluna e setar ela como PK
	ALTER TABLE FUNCIONARIO MODIFY COLUMN id INT NOT NULL; -- Tira o auto increment
	ALTER TABLE FUNCIONARIO ADD CPF VARCHAR(11);
	ALTER TABLE FUNCIONARIO MODIFY COLUMN CPF VARCHAR(11) NOT NULL; -- Transforma a coluna que vai ser pk em not null
	ALTER TABLE FUNCIONARIO DROP PRIMARY KEY; -- Dropa a pk antiga	
    ALTER TABLE FUNCIONARIO ADD PRIMARY KEY (CPF); -- Insere a nova pk
    select * from FUNCIONARIO
