insert into cozinha (id, nome) values (100, 'Tailandesa');
insert into cozinha (id, nome) values (200, 'Indiana');

insert into estado (id, nome) values (100, 'Pará');
insert into estado (id, nome) values (200, 'Amapá');
insert into estado (id, nome) values (300, 'Ceará');

insert into cidade (id, nome, estado_id) values (100, 'Belém', 100);
insert into cidade (id, nome, estado_id) values (200, 'Ananindeua', 100);
insert into cidade (id, nome, estado_id) values (300, 'Macapá', 200);
insert into cidade (id, nome, estado_id) values (400, 'Santana', 200);
insert into cidade (id, nome, estado_id) values (500, 'Fortaleza', 300);

insert into restaurante (id, nome, taxa_frete, cozinha_id, endereco_cidade_id, endereco_logradouro, endereco_numero, endereco_bairro, endereco_cep) values (100, 'Thai Gourmet', 10, 100, 100,'Rua Quatorze A', 41, 'Maracangalha', '66110-058');
insert into restaurante (id, nome, taxa_frete, cozinha_id, endereco_cidade_id, endereco_logradouro, endereco_numero, endereco_bairro, endereco_cep) values (200, 'Thai Delivery', 9.50, 100, 200,'Av. Poeta Castro Alves', 1451,'Central', '66009-123');
insert into restaurante (id, nome, taxa_frete, cozinha_id, endereco_cidade_id, endereco_logradouro, endereco_numero, endereco_bairro, endereco_cep) values (300, 'Tuk Tuk Comida Indiana', 15, 200, 300,'Rua Cearense',229,'Bom Passos','54231-548');

insert into forma_pagamento (id, descricao) values (100, 'Cartão de crédito');
insert into forma_pagamento (id, descricao) values (200, 'Cartão de débito');
insert into forma_pagamento (id, descricao) values (300, 'Dinheiro');

insert into permissao (id, nome, descricao) values (100, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into permissao (id, nome, descricao) values (200, 'EDITAR_COZINHAS', 'Permite editar cozinhas');

insert into restaurante_forma_pagamento(restaurante_id, forma_pagamento_id) values (100, 100),(100,200),(100,300),(200,300),(300,200),(300,300);