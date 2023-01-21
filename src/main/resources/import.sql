truncate table cidade restart identity cascade;
truncate table cozinha restart identity cascade;
truncate table estado restart identity cascade;
truncate table forma_pagamento restart identity cascade;
truncate table grupo restart identity cascade;
truncate table permissao restart identity cascade;
truncate table produto restart identity cascade;
truncate table restaurante restart identity cascade;
truncate table usuario restart identity cascade;

insert into cozinha (id, nome) values (100, 'Tailandesa');
insert into cozinha (id, nome) values (200, 'Indiana');
insert into cozinha (id, nome) values (300, 'Argentina');
insert into cozinha (id, nome) values (400, 'Brasileira');

insert into estado (id, nome) values (100, 'Pará');
insert into estado (id, nome) values (200, 'Amapá');
insert into estado (id, nome) values (300, 'Ceará');

insert into cidade (id, nome, estado_id) values (100, 'Belém', 100);
insert into cidade (id, nome, estado_id) values (200, 'Ananindeua', 100);
insert into cidade (id, nome, estado_id) values (300, 'Macapá', 200);
insert into cidade (id, nome, estado_id) values (400, 'Santana', 200);
insert into cidade (id, nome, estado_id) values (500, 'Fortaleza', 300);

insert into restaurante (id, nome, ativo, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cidade_id, endereco_logradouro, endereco_numero, endereco_bairro, endereco_cep ) values ( 100, 'Thai Gourmet', true, 10, 100, current_timestamp, current_timestamp, 100, 'Rua Quatorze A', 41, 'Maracangalha', '66110-058' );
insert into restaurante (id, nome, ativo, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cidade_id, endereco_logradouro, endereco_numero, endereco_bairro, endereco_cep ) values ( 200, 'Thai Delivery', true, 9.50, 100, current_timestamp, current_timestamp, 200, 'Av. Poeta Castro Alves', 1451, 'Central', '66009-123' );
insert into restaurante (id, nome, ativo, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cidade_id, endereco_logradouro, endereco_numero, endereco_bairro, endereco_cep ) values ( 300, 'Tuk Tuk Comida Indiana', true, 15, 200, current_timestamp, current_timestamp, 300, 'Rua Cearense', 229, 'Bom Passos', '54231-548' );
insert into restaurante (id, nome, ativo, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cidade_id, endereco_logradouro, endereco_numero, endereco_bairro, endereco_cep ) values ( 400, 'Java Steakhouse', true, 12, 300, current_timestamp, current_timestamp, 100, 'Rua Quatorze A', 41, 'Maracangalha', '66110-058' );
insert into restaurante (id, nome, ativo, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cidade_id, endereco_logradouro, endereco_numero, endereco_bairro, endereco_cep ) values ( 500, 'Lanchonete do Tio Sam', true, 11, 100, current_timestamp, current_timestamp, 200, 'Av. Poeta Castro Alves', 1451, 'Central', '66009-123' );
insert into restaurante (id, nome, ativo, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cidade_id, endereco_logradouro, endereco_numero, endereco_bairro, endereco_cep ) values ( 600, 'Bar da Maria', true, 6, 200, current_timestamp, current_timestamp, 300, 'Rua Cearense', 229, 'Bom Passos', '54231-548' );

insert into forma_pagamento (id, descricao) values (100, 'Cartão de crédito');
insert into forma_pagamento (id, descricao) values (200, 'Cartão de débito');
insert into forma_pagamento (id, descricao) values (300, 'Dinheiro');

insert into permissao (id, nome, descricao) values ( 100, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas' );
insert into permissao (id, nome, descricao) values ( 200, 'EDITAR_COZINHAS', 'Permite editar cozinhas' );

insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (100, 100), (100, 200), (100, 300), (200, 300), (300, 200), (300, 300), (400, 100), (400, 200), (500, 100), (500, 200), (600, 300);

insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Porco com molho agridoce', 'Deliciosa carne suína ao molho especial', 78.90, true, 100);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Camarão tailandês', '16 camarões grandes ao molho picante', 110, true, 100);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Salada picante com carne grelhada', 'Salada de folhas com cortes finos de carne bovina grelhada e nosso molho especial de pimenta vermelha', 87.20, true, 200);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Garlic Naan', 'Pão tradicional indiano com cobertura de alho', 21, true, 300);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Murg Curry', 'Cubos de frango preparados com molho curry e especiarias', 43, true, 300);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Bife Ancho', 'Corte macio e suculento, com dois dedos de espessura, retirado da parte dianteira do contrafilé', 79, true, 400);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('T-Bone', 'Corte muito saboroso, com um osso em formato de T, sendo de um lado o contrafilé e do outro o filé mignon', 89, true, 400);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Sanduíche X-Tudo', 'Sandubão com muito queijo, hamburger bovino, bacon, ovo, salada e maionese', 19, true, 500);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Espetinho de Cupim', 'Acompanha farinha, mandioca e vinagrete', 8, true, 600);

insert into grupo (id, nome) values (100, 'Gerente');
insert into grupo (id, nome) values (200, 'Vendedor');
insert into grupo (id, nome) values (300, 'Secretária');
insert into grupo (id, nome) values (400, 'Cadastrador');

insert into usuario (id, nome, email, senha, data_cadastro, data_atualizacao) values (100, 'João da Silva','joao.ger@cadufood.com', '123', current_timestamp, current_timestamp);
insert into usuario (id, nome, email, senha, data_cadastro, data_atualizacao) values (200, 'Maria Joaquina','maria.vnd@cadufood.com', '123',current_timestamp, current_timestamp);
insert into usuario (id, nome, email, senha, data_cadastro, data_atualizacao) values (300, 'José Souza','jose.sec@cadufood.com', '123',current_timestamp, current_timestamp);
insert into usuario (id, nome, email, senha, data_cadastro, data_atualizacao) values (400, 'Sebastião Martins','sebastiao.cad@cadufood.com', '123',current_timestamp, current_timestamp);

