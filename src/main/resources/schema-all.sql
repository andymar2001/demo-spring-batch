DROP TABLE tp_personas IF EXISTS;

CREATE TABLE tp_personas(
    cod_persona BIGINT IDENTITY NOT NULL PRIMARY KEY,
    nombre VARCHAR(20),
    apellido1 VARCHAR(20),
    telefono VARCHAR(20)
);