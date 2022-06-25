--tb_user
INSERT INTO tb_user (first_name, last_name, birth_date, email, password, created_at, status) VALUES ('Alex', 'Brown', '26/07/1977', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', now(), 0);
INSERT INTO tb_user (first_name, last_name, birth_date, email, password, created_at, status) VALUES ('Maria', 'Green', '26/07/1977', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', now(), 0);
INSERT INTO tb_user (first_name, last_name, birth_date, email, password, created_at, status) VALUES ('João', 'Silva', '26/07/1977','joao@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', now(), 0);
INSERT INTO tb_user (first_name, last_name, birth_date, email, password, created_at, status) VALUES ('Ana', 'Pereira', '26/07/1977','ana@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', now(), 0);
INSERT INTO tb_user (first_name, last_name, birth_date, email, password, created_at, status) VALUES ('Joaquim', 'Ferreira', '26/07/1977','joaquim@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', now(), 0);

--tb_role
INSERT INTO tb_role (authority, created_at, status) VALUES ('ROLE_OPERATOR', now(), 0);
INSERT INTO tb_role (authority, created_at, status) VALUES ('ROLE_STUDENT', now(), 0);
INSERT INTO tb_role (authority, created_at, status) VALUES ('ROLE_INSTRUCTOR', now(), 0);
INSERT INTO tb_role (authority, created_at, status) VALUES ('ROLE_ADMIN', now(), 0);

--tb_user_role
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 3);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 4);

--Insert tb_category
INSERT INTO tb_category_product (name, created_at, status) VALUES ('Books', NOW(), 0);
INSERT INTO tb_category_product (name, created_at, status) VALUES ('Eletronics', NOW(), 0);
INSERT INTO tb_category_product (name, created_at, status) VALUES ('Computers', NOW(), 0);

INSERT INTO tb_product (code, name, price, image_Uri, description, created_at, status) VALUES ('3a973c8f-d5a5-4a0a-950f-b4e79a35a895', 'Pizza Bacon', 49.9, 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/pizza_bacon.jpg', 'Pizza de bacon com mussarela, orégano, molho especial e tempero da casa.', NOW(), 0);
INSERT INTO tb_product (code, name, price, image_Uri, description, created_at, status) VALUES ('66c6f671-c2e1-4d60-a16c-ebc3be0d6870', 'Pizza Moda da Casa', 59.9, 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/pizza_moda.jpg', 'Pizza à moda da casa, com molho especial e todos ingredientes básicos, e queijo à sua escolha.', NOW(), 0);
INSERT INTO tb_product (code, name, price, image_Uri, description, created_at, status) VALUES ('7a384618-b209-4978-b611-85e0026102e8', 'Pizza Portuguesa', 45.0, 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/pizza_portuguesa.jpg', 'Pizza Portuguesa com molho especial, mussarela, presunto, ovos e especiarias.', NOW(), 0);
INSERT INTO tb_product (code, name, price, image_Uri, description, created_at, status) VALUES ('40b302b2-31ff-451f-85c2-c7a163bf41af', 'Risoto de Carne', 52.0,'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/risoto_carne.jpg', 'Risoto de carne com especiarias e um delicioso molho de acompanhamento.', NOW(), 0);
INSERT INTO tb_product (code, name, price, image_Uri, description, created_at, status) VALUES ('51db1297-5173-4f3d-a327-478c0101aee4', 'Risoto Funghi', 59.95, 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/risoto_funghi.jpg', 'Risoto Funghi feito com ingredientes finos e o toque especial do chef.', NOW(), 0);
INSERT INTO tb_product (code, name, price, image_Uri, description, created_at, status) VALUES ('185eefbd-97b7-467f-8cc5-708551a70de3', 'Macarrão Espaguete',35.9, 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/macarrao_espaguete.jpg', 'Macarrão fresco espaguete com molho especial e tempero da casa.', NOW(), 0);
INSERT INTO tb_product (code, name, price, image_Uri, description, created_at, status) VALUES ('9f6ccaed-9e01-43cc-8baf-9343fcd3ccb8', 'Macarrão Fusili', 38.0,'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/macarrao_fusili.jpg', 'Macarrão fusili com toque do chef e especiarias.', NOW(), 0);
INSERT INTO tb_product (code, name, price, image_Uri, description, created_at, status) VALUES ('946e72ea-7f99-47e3-9e9f-02cc39d09b89', 'Macarrão Penne', 37.9,'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/macarrao_penne.jpg', 'Macarrão penne fresco ao dente com tempero especial.', NOW(), 0);

INSERT INTO tb_product_category (product_id, category_id) VALUES (1, 2);
INSERT INTO tb_product_category (product_id, category_id) VALUES (2, 1);
INSERT INTO tb_product_category (product_id, category_id) VALUES (2, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (3, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (4, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (5, 2);

INSERT INTO tb_order (status, latitude, longitude, address, moment) VALUES (0, -23.561680, -46.656139, 'Avenida Paulista, 1500', '2021-01-01T10:00:00Z');
INSERT INTO tb_order (status, latitude, longitude, address, moment) VALUES (1, -22.946779, -43.217753, 'Avenida Paulista, 1500', '2021-01-01T15:00:00Z');
INSERT INTO tb_order (status, latitude, longitude, address, moment) VALUES (0, -25.439787, -49.237759, 'Avenida Paulista, 1500', '2021-01-01T16:00:00Z');
INSERT INTO tb_order (status, latitude, longitude, address, moment) VALUES (0, -23.561680, -46.656139, 'Avenida Paulista, 1500', '2021-01-01T12:00:00Z');
INSERT INTO tb_order (status, latitude, longitude, address, moment) VALUES (1, -23.561680, -46.656139, 'Avenida Paulista, 1500', '2021-01-01T08:00:00Z');
INSERT INTO tb_order (status, latitude, longitude, address, moment) VALUES (0, -23.561680, -46.656139, 'Avenida Paulista, 1500', '2021-01-01T14:00:00Z');
INSERT INTO tb_order (status, latitude, longitude, address, moment) VALUES (0, -23.561680, -46.656139, 'Avenida Paulista, 1500', '2021-01-01T09:00:00Z');

INSERT INTO tb_order_product (order_id, product_id) VALUES (1 , 1);
INSERT INTO tb_order_product (order_id, product_id) VALUES (1 , 4);
INSERT INTO tb_order_product (order_id, product_id) VALUES (2 , 2);
INSERT INTO tb_order_product (order_id, product_id) VALUES (2 , 5);
INSERT INTO tb_order_product (order_id, product_id) VALUES (2 , 8);
INSERT INTO tb_order_product (order_id, product_id) VALUES (3 , 3);
INSERT INTO tb_order_product (order_id, product_id) VALUES (3 , 4);
INSERT INTO tb_order_product (order_id, product_id) VALUES (4 , 2);
INSERT INTO tb_order_product (order_id, product_id) VALUES (4 , 6);
INSERT INTO tb_order_product (order_id, product_id) VALUES (5 , 4);
INSERT INTO tb_order_product (order_id, product_id) VALUES (5 , 6);
INSERT INTO tb_order_product (order_id, product_id) VALUES (6 , 5);
INSERT INTO tb_order_product (order_id, product_id) VALUES (6 , 1);
INSERT INTO tb_order_product (order_id, product_id) VALUES (7 , 7);
INSERT INTO tb_order_product (order_id, product_id) VALUES (7 , 5);