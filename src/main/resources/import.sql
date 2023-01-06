insert into cozinha (id, nome) values (100, 'Tailandesa');
insert into cozinha (id, nome) values (200, 'Indiana');

insert into restaurante (id, nome, taxa_frete, cozinha_id) values (100, 'Thai Gourmet', 10, 100);
insert into restaurante (id, nome, taxa_frete, cozinha_id) values (200, 'Thai Delivery', 9.50, 100);
insert into restaurante (id, nome, taxa_frete, cozinha_id) values (300, 'Tuk Tuk Comida Indiana', 15, 200);

insert into estado (id, nome) values (100, 'Minas Gerais');
insert into estado (id, nome) values (200, 'São Paulo');
insert into estado (id, nome) values (300, 'Ceará');

insert into cidade (id, nome, estado_id) values (100, 'Uberlândia', 100);
insert into cidade (id, nome, estado_id) values (200, 'Belo Horizonte', 100);
insert into cidade (id, nome, estado_id) values (300, 'São Paulo', 200);
insert into cidade (id, nome, estado_id) values (400, 'Campinas', 200);
insert into cidade (id, nome, estado_id) values (500, 'Fortaleza', 300);

insert into forma_pagamento (id, descricao) values (100, 'Cartão de crédito');
insert into forma_pagamento (id, descricao) values (200, 'Cartão de débito');
insert into forma_pagamento (id, descricao) values (300, 'Dinheiro');

insert into permissao (id, nome, descricao) values (100, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into permissao (id, nome, descricao) values (200, 'EDITAR_COZINHAS', 'Permite editar cozinhas');
