-- CRIAÇÃO BANCO DE DADOS 

use db_atacado_eletronico;
-- 1. Deleta tabelas em ordem reversa de dependência
DROP TABLE IF EXISTS nf_item;
DROP TABLE IF EXISTS nf_cabecalho;
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS user;


-- 2. Cria tabelas

CREATE TABLE logradouro (
  cep VARCHAR(9) PRIMARY KEY,
  street VARCHAR(100),
  district VARCHAR(50),
  number_local VARCHAR(10),
  country VARCHAR(50),
  complement VARCHAR(100)
);

CREATE TABLE manufacturer (
  cnpj VARCHAR(18) PRIMARY KEY,
  name VARCHAR(100),
  cep VARCHAR(9),
  FOREIGN KEY (cep) REFERENCES logradouro(cep)
);

CREATE TABLE `user` (
  cpf_cnpj VARCHAR(18) PRIMARY KEY,
  name VARCHAR(100),
  dt_birth DATE,
  email VARCHAR(100),
  password VARCHAR(100),
  phone VARCHAR(20),
  cep VARCHAR(9),
  gender VARCHAR(10),
  type_people VARCHAR(20),
  FOREIGN KEY (cep) REFERENCES logradouro(cep)
);

CREATE TABLE item (
  id_item INT PRIMARY KEY AUTO_INCREMENT,
  categoria VARCHAR(50),
  price DECIMAL(10,2),
  qtde_item_STOKE INT,
  descr_item TEXT,
  manufacture VARCHAR(18),
  name VARCHAR(100),
  situacao VARCHAR(20),
  FOREIGN KEY (manufacture) REFERENCES manufacturer(cnpj)
);

CREATE TABLE nf_header (
  num_nf INT PRIMARY KEY,
  dt_buyer DATE,
  cpf_buyer VARCHAR(18),
  cnpj_issuer VARCHAR(18),
  FOREIGN KEY (cpf_buyer) REFERENCES `user`(cpf_cnpj),
  FOREIGN KEY (cnpj_issuer) REFERENCES `user`(cpf_cnpj)
);

CREATE TABLE nf_item (
  num_nf INT,
  id_item INT,
  cod_item VARCHAR(50),
  PRIMARY KEY (num_nf, id_item),
  FOREIGN KEY (num_nf) REFERENCES nf_header(num_nf),
  FOREIGN KEY (id_item) REFERENCES item(id_item)
);

CREATE TABLE `order` (
  num_order INT PRIMARY KEY AUTO_INCREMENT,
  cpf_user VARCHAR(18),
  dt_order DATE,
  dt_delivery DATE,
  price_order DECIMAL(10,2),
  FOREIGN KEY (cpf_user) REFERENCES `user`(cpf_cnpj)
);

CREATE TABLE items_order (
  id_item INT,
  num_order INT,
  qtde_order INT,
  cnpj_manufacturer VARCHAR(18),
  qtde INT,
  price_order DECIMAL(10,2),
  PRIMARY KEY (id_item, num_order),
  FOREIGN KEY (id_item) REFERENCES item(id_item),
  FOREIGN KEY (num_order) REFERENCES `order`(num_order),
  FOREIGN KEY (cnpj_manufacturer) REFERENCES manufacturer(cnpj)
);

CREATE table `company`(
	cnpj INT primary key auto_increment,
    name varchar(18),
    dt_birth date,
    cep varchar(10),
    foreign key (cep) references `logradouro`(cep)
);

