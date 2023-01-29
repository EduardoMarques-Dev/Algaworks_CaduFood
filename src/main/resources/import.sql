truncate table cidade restart identity cascade;
truncate table cozinha restart identity cascade;
truncate table estado restart identity cascade;
truncate table forma_pagamento restart identity cascade;
truncate table grupo restart identity cascade;
truncate table permissao restart identity cascade;
truncate table produto restart identity cascade;
truncate table restaurante restart identity cascade;
truncate table usuario restart identity cascade;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

insert into cozinha (id, codigo, nome) values (100, 'codigo', 'Tailandesa');
insert into cozinha (id, codigo, nome) values (200, uuid_generate_v4(), 'Indiana');
insert into cozinha (id, codigo, nome) values (300, uuid_generate_v4(), 'Argentina');
insert into cozinha (id, codigo, nome) values (400, uuid_generate_v4(), 'Brasileira');

insert into estado (id, codigo, nome) values (100, 'codigo', 'Pará');
insert into estado (id, codigo, nome) values (200, uuid_generate_v4(), 'Amapá');
insert into estado (id, codigo, nome) values (300, uuid_generate_v4(), 'Ceará');

insert into cidade (id, codigo, nome, estado_id) values (100, 'codigo', 'Belém', 100);
insert into cidade (id, codigo, nome, estado_id) values (200, uuid_generate_v4(), 'Ananindeua', 100);
insert into cidade (id, codigo, nome, estado_id) values (300, uuid_generate_v4(), 'Macapá', 200);
insert into cidade (id, codigo, nome, estado_id) values (400, uuid_generate_v4(), 'Santana', 200);
insert into cidade (id, codigo, nome, estado_id) values (500, uuid_generate_v4(), 'Fortaleza', 300);

insert into restaurante (id, codigo, nome, ativo, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cidade_id, endereco_logradouro, endereco_numero, endereco_bairro, endereco_cep ) values ( 100, 'codigo', 'Thai Gourmet', true, 10, 100, current_timestamp, current_timestamp, 100, 'Rua Quatorze A', 41, 'Maracangalha', '66110-058' );
insert into restaurante (id, codigo, nome, ativo, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cidade_id, endereco_logradouro, endereco_numero, endereco_bairro, endereco_cep ) values ( 200, uuid_generate_v4(), 'Thai Delivery', true, 9.50, 100, current_timestamp, current_timestamp, 200, 'Av. Poeta Castro Alves', 1451, 'Central', '66009-123' );
insert into restaurante (id, codigo, nome, ativo, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cidade_id, endereco_logradouro, endereco_numero, endereco_bairro, endereco_cep ) values ( 300, uuid_generate_v4(), 'Tuk Tuk Comida Indiana', true, 15, 200, current_timestamp, current_timestamp, 300, 'Rua Cearense', 229, 'Bom Passos', '54231-548' );
insert into restaurante (id, codigo, nome, ativo, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cidade_id, endereco_logradouro, endereco_numero, endereco_bairro, endereco_cep ) values ( 400, uuid_generate_v4(), 'Java Steakhouse', true, 12, 300, current_timestamp, current_timestamp, 100, 'Rua Quatorze A', 41, 'Maracangalha', '66110-058' );
insert into restaurante (id, codigo, nome, ativo, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cidade_id, endereco_logradouro, endereco_numero, endereco_bairro, endereco_cep ) values ( 500, uuid_generate_v4(), 'Lanchonete do Tio Sam', true, 11, 100, current_timestamp, current_timestamp, 200, 'Av. Poeta Castro Alves', 1451, 'Central', '66009-123' );
insert into restaurante (id, codigo, nome, ativo, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cidade_id, endereco_logradouro, endereco_numero, endereco_bairro, endereco_cep ) values ( 600, uuid_generate_v4(), 'Bar da Maria', true, 6, 200, current_timestamp, current_timestamp, 300, 'Rua Cearense', 229, 'Bom Passos', '54231-548' );

insert into forma_pagamento (id, codigo, descricao) values (100, 'codigo', 'Cartão de crédito');
insert into forma_pagamento (id, codigo, descricao) values (200, uuid_generate_v4(), 'Cartão de débito');
insert into forma_pagamento (id, codigo, descricao) values (300, uuid_generate_v4(), 'Dinheiro');

insert into permissao (id, codigo, nome, descricao) values ( 100, 'codigo', 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas' );
insert into permissao (id, codigo, nome, descricao) values ( 200, uuid_generate_v4(), 'EDITAR_COZINHAS', 'Permite editar cozinhas' );

insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (100, 100), (100, 200), (100, 300), (200, 300), (300, 200), (300, 300), (400, 100), (400, 200), (500, 100), (500, 200), (600, 300);

insert into produto (codigo, nome, descricao, preco, ativo, restaurante_id) values ('codigo', 'Porco com molho agridoce', 'Deliciosa carne suína ao molho especial', 78.90, true, 100);
insert into produto (codigo, nome, descricao, preco, ativo, restaurante_id) values (uuid_generate_v4(), 'Camarão tailandês', '16 camarões grandes ao molho picante', 110, true, 100);
insert into produto (codigo, nome, descricao, preco, ativo, restaurante_id) values (uuid_generate_v4(), 'Salada picante com carne grelhada', 'Salada de folhas com cortes finos de carne bovina grelhada e nosso molho especial de pimenta vermelha', 87.20, true, 200);
insert into produto (codigo, nome, descricao, preco, ativo, restaurante_id) values (uuid_generate_v4(), 'Garlic Naan', 'Pão tradicional indiano com cobertura de alho', 21, true, 300);
insert into produto (codigo, nome, descricao, preco, ativo, restaurante_id) values (uuid_generate_v4(), 'Murg Curry', 'Cubos de frango preparados com molho curry e especiarias', 43, true, 300);
insert into produto (codigo, nome, descricao, preco, ativo, restaurante_id) values (uuid_generate_v4(), 'Bife Ancho', 'Corte macio e suculento, com dois dedos de espessura, retirado da parte dianteira do contrafilé', 79, true, 400);
insert into produto (codigo, nome, descricao, preco, ativo, restaurante_id) values (uuid_generate_v4(), 'T-Bone', 'Corte muito saboroso, com um osso em formato de T, sendo de um lado o contrafilé e do outro o filé mignon', 89, true, 400);
insert into produto (codigo, nome, descricao, preco, ativo, restaurante_id) values (uuid_generate_v4(), 'Sanduíche X-Tudo', 'Sandubão com muito queijo, hamburger bovino, bacon, ovo, salada e maionese', 19, true, 500);
insert into produto (codigo, nome, descricao, preco, ativo, restaurante_id) values (uuid_generate_v4(), 'Espetinho de Cupim', 'Acompanha farinha, mandioca e vinagrete', 8, true, 600);

insert into grupo (id, codigo, nome) values (100, 'codigo', 'Gerente');
insert into grupo (id, codigo, nome) values (200, uuid_generate_v4(), 'Vendedor');
insert into grupo (id, codigo, nome) values (300, uuid_generate_v4(), 'Secretária');
insert into grupo (id, codigo, nome) values (400, uuid_generate_v4(), 'Cadastrador');

insert into usuario (id, codigo, nome, email, senha, data_cadastro, data_atualizacao) values (100, 'codigo', 'João da Silva','joao.ger@cadufood.com', '123', current_timestamp, current_timestamp);
insert into usuario (id, codigo, nome, email, senha, data_cadastro, data_atualizacao) values (200, uuid_generate_v4(), 'Maria Joaquina','maria.vnd@cadufood.com', '123',current_timestamp, current_timestamp);
insert into usuario (id, codigo, nome, email, senha, data_cadastro, data_atualizacao) values (300, uuid_generate_v4(), 'José Souza','jose.sec@cadufood.com', '123',current_timestamp, current_timestamp);
insert into usuario (id, codigo, nome, email, senha, data_cadastro, data_atualizacao) values (400, uuid_generate_v4(), 'Sebastião Martins','sebastiao.cad@cadufood.com', '123',current_timestamp, current_timestamp);

