# API - Delivery :motorcycle: :motor_scooter: 

Projeto back end simplificado da parte de cadastro de usuários, produtos e de compras com produtos escolhidos.

### FUNCIONAMENTO

O projeto possui quatro entidades que se relacionam. A partir de um pacote é possível controlar o cadastro das quatro tabelas, assim como exclusão ou edição(em alguns casos). Existem pacotes para transferência de dados e outro para utilizar métodos da JPA.

### PACOTES

1. model;
2. dto;
3. form;
4. repository;
5. controller;

##### model

> Pacote onde são criadas as entidades (Client, Product, Shopping e SelectedProducts).

##### dto

> Pacote para pegar alguns atributos das classes do pacote modelo e transcreve-los em outro tipo de objeto para proteger e restringir o acesso a classe principal. Aqui também ficam os métodos que realizam a transferência.

##### form

> Parecido com o pacote dto, mas apenas para client e produto.

##### repository

> Pacote de interface JpaRepository, cada entidade possui a sua e é usada no controller para acesso ao banco de dados.

##### controller

> Pacote de criação dos métodos GET, POST, PUT e DELETE da API. Esse pacote combina o uso de todos os outros para gerenciar a API e suas funcionalidades.