-- criando a base de dados;
CREATE DATABASE aula01;

-- Selecionar base de dados;
USE aula01;

-- criar tabela;
CREATE TABLE alunos(
	nome varchar(20),
    nota1 DOUBLE,
    nota2 DOUBLE,
    turno CHAR
);

-- adicionar Dados
INSERT INTO alunos VALUES(
	'Jefferson Bisatto',
    7,
    9,
    'V'
);
INSERT INTO alunos (nota1, nota2) VALUES (5,90);
INSERT INTO alunos VALUES 
('João',8,9,'M'),
('Maria',8,7,'N'),
('Pedro',8,6,'V');

-- Selecionar
SELECT * FROM alunos; 	
SELECT nome FROM alunos; 
SELECT nome, (nota1+nota2)/2 AS média FROM alunos; 
SELECT IF((nota1+nota2)/2>=7,' Aprovado',' Reprovado') AS Situação FROM alunos;
SELECT CONCAT ( nome, IF((nota1+nota2)/2>=7,' Aprovado',' Reprovado')) AS Situação FROM alunos;
SELECT COUNT(*) FROM alunos;
SELECT AVG(nota1) FROM alunos;-- media
SELECT MAX(nota1) FROM alunos;
SELECT MIN(nota1) FROM alunos;
SELECT turno FROM alunos;
SELECT
	CASE
		WHEN turno = 'm' then 'Matutino'
        WHEN turno = 'v' then 'Vespertino'
        WHEN turno = 'n' then 'Nortuno'
		ELSE 'Turno não Especificado'
	END AS 	'Turno'
FROM alunos;
SELECT * FROM alunos WHERE 	nome IS NOT NULL;
SELECT * FROM alunos WHERE turno = 'v';
SELECT turno FROM alunos GROUP BY turno;
SELECT turno, COUNT(turno) FROM alunos GROUP BY turno;
SELECT turno, COUNT(turno) FROM alunos WHERE  turno IS NOT NULL GROUP BY turno;
SELECT nome FROM alunos WHERE nome IS NOT NULL;
SELECT nome FROM alunos WHERE nome IS NOT NULL ORDER BY nome;
SELECT nome FROM alunos WHERE nome IS NOT NULL ORDER BY nome ASC;
SELECT nome FROM alunos WHERE nome IS NOT NULL ORDER BY nome DESC;
SELECT nome FROM alunos WHERE nome LIKE "%a"; -- finaliza
SELECT nome FROM alunos WHERE nome LIKE "a%"; -- começa
SELECT nome FROM alunos WHERE nome LIKE "%a%"; -- contem

-- Liberar a alateração e exclusão de dados
SET SQL_SAFE_UPDATES = 0;

-- Alterar dados
UPDATE alunos SET nome = 'Dênis' WHERE nome IS NULL;

-- Remover Dados 
DELETE FROM alunos  WHERE nome = "Maria";

-- Remover Tabela
DROP TABLE alunos;

-- Remover base de dados
DROP DATABASE aula01;
