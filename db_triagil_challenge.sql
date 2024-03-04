DROP DATABASE IF EXISTS db_triagil_challenge;
CREATE DATABASE IF NOT EXISTS db_triagil_challenge;
USE db_triagil_challenge;

CREATE TABLE IF NOT EXISTS tb_team
(
    id    BIGINT UNSIGNED AUTO_INCREMENT,
    owner VARCHAR(255) NOT NULL,

    UNIQUE (owner),

    primary key (id)
);

CREATE TABLE IF NOT EXISTS team_pokemons
(
    team_id  BIGINT UNSIGNED AUTO_INCREMENT,
    pokemons VARCHAR(255) NOT NULL,

    PRIMARY KEY (team_id),

    FOREIGN KEY (team_id) REFERENCES tb_team (id)
);