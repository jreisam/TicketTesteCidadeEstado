DROP TABLE IF EXISTS cidade;
DROP TABLE IF EXISTS estado;

CREATE TABLE estado
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome     varchar(100),
    sigla    varchar(50),
    img_nome varchar(100),
    PRIMARY KEY (id),
    UNIQUE (nome)
);

CREATE TABLE cidade
(
    id        BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome      varchar(150) NOT NULL,
    populacao BIGINT       NOT NULL,
    estado_id BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (estado_id) REFERENCES estado (id) ON DELETE CASCADE
);


INSERT INTO estado(id, nome, sigla)
VALUES (1, 'Rio Grande do Sul', 'rs'),
       (2, 'Santa Catarina', 'sc'),
       (3, 'Paraná', 'pn');

INSERT INTO cidade(id, nome, populacao, estado_id)
VALUES (1, 'Porto Alegre', 1793000, 1),
       (2, 'Gramado', 94175, 1),
       (3, 'Pelotas', 101337, 1),
       (4, 'Joinville', 140900, 2),
       (5, 'Blumenau', 22300, 2),
       (6, 'Balneário Camboriú', 157000, 2),
       (7, 'Curitiba', 121100, 3),
       (8, 'Londrina', 939300, 3);
