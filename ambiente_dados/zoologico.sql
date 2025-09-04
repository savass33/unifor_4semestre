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
ALTER TABLE FUNCIONARIO ADD COLUMN cpf VARCHAR(11);

-- cpfs temporários com base no id
UPDATE FUNCIONARIO SET cpf = id;

-- Remove auto da coluna antiga
ALTER TABLE FUNCIONARIO MODIFY COLUMN id INT NOT NULL;

-- Dropa a pk antiga
ALTER TABLE FUNCIONARIO DROP PRIMARY KEY;

-- seta CPF como NOT NULL e define como a nova PK
ALTER TABLE FUNCIONARIO MODIFY COLUMN cpf VARCHAR(11) NOT NULL;
ALTER TABLE FUNCIONARIO ADD PRIMARY KEY (cpf);

SELECT * FROM FUNCIONARIO;
SHOW CREATE TABLE FUNCIONARIO;


-- ------------- Outra forma com FK ------------ ---

drop table RefPriKey;
SHOW CREATE TABLE RefPriKey;
SELECT * FROM RefPriKey;

-- Cria uma tabela auxiliar que servirá apenas para armazenar CPFs válidos
create table RefPriKey(
    cpf VARCHAR(11) PRIMARY KEY
);

-- Remove o AUTO_INCREMENT da coluna id de FUNCIONARIO
ALTER TABLE FUNCIONARIO MODIFY COLUMN id INT NOT NULL;

-- Dropa a chave primária antiga (que estava em id)
ALTER TABLE FUNCIONARIO DROP PRIMARY KEY;

-- Adiciona a coluna cpf na tabela FUNCIONARIO
ALTER TABLE FUNCIONARIO ADD COLUMN cpf VARCHAR(11);

-- Cria uma Foreign Key ligando FUNCIONARIO.cpf com RefPriKey.cpf
-- Isso garante que só pode existir cpf em FUNCIONARIO se ele já existir em RefPriKey
ALTER TABLE FUNCIONARIO ADD CONSTRAINT fk_funcionario_cpf FOREIGN KEY (cpf) REFERENCES RefPriKey(cpf);

-- Insere CPFs válidos primeiro na tabela de referência (RefPriKey)
insert into RefPriKey(cpf) values
('00011122233'),
('3332221100');

select * from RefPriKey;

-- Agora insere funcionários em FUNCIONARIO, referenciando os CPFs já existentes em RefPriKey
INSERT INTO FUNCIONARIO (nome, cargo, idade, sexo, telefone, estado, cpf) VALUES
('Savas', 'Cafetão', 35, 'H', '(85) 99999-1234', 'Ativo', '00011122233'),
('Wermont', 'Prostituta', 72, 'M', '(85) 98888-5678', 'Inativo', '3332221100');
