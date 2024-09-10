-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS stockearte;

-- Usar la base de datos
USE stockearte;

CREATE TABLE IF NOT EXISTS stores (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(20) NOT NULL UNIQUE,  -- Código alfanumérico único
    address VARCHAR(50) NOT NULL,
    city VARCHAR(50) NOT NULL,
    province VARCHAR(50) NOT NULL,
    enabled BOOLEAN NOT NULL  -- Habilitado/Deshabilitado
);

CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(20) NOT NULL UNIQUE,  -- Nombre de usuario único
    password VARCHAR(20) NOT NULL,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    enabled BOOLEAN NOT NULL,  -- Habilitado/Deshabilitado
    store_id BIGINT,  -- Relación con la tienda (puede ser NULL para casa central)
    FOREIGN KEY (store_id) REFERENCES stores(id) ON DELETE SET NULL  -- Relación con la tabla Store
);

CREATE TABLE IF NOT EXISTS products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    code CHAR(10) NOT NULL UNIQUE,  -- Código único de 10 caracteres
    name VARCHAR(50) NOT NULL,
    size VARCHAR(20) NOT NULL,
    color VARCHAR(20) NOT NULL,
    photo VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS stores_products (
    store_id BIGINT,
    product_id BIGINT,
    PRIMARY KEY (store_id, product_id),
    FOREIGN KEY (store_id) REFERENCES stores(id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS stocks (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    store_id BIGINT NOT NULL,  -- Relación con la tienda
    product_id BIGINT NOT NULL,  -- Relación con el producto
    quantity INT NOT NULL DEFAULT 0,  -- Cantidad de stock
    FOREIGN KEY (store_id) REFERENCES stores(id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE
);
