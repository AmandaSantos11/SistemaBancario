# Sistema Bancário 🏦 

*Atividade voltada para treinar criação de banco de dados no PostgreSQL.*

***Objetivo:*** Criar um sistema bancário com funcionalidades básicas.

<hr>

**Requisitos da atividade:**

*Tabelas com seus respectivos campos 📄*

- ContaBancaria:
  - id;
  - numero_conta;
  - saldo;
  - id_client (chave estrangeira para tabela Cliente).


- Cliente:
  - id;
  - nome;
  - cpf;
  - endereco.

- Transacao:
  - id;
  - data;
  - -valor;
  - conta_origem_id (chave estrangeira para a tabela ContaBancaria);
  - conta_destino_id (chave estrangeira para a tabela ContaBancaria).

*Funcionalidades* 🔧

- Criar Conta Bancária: Crie uma classe Java para
  representar uma conta bancária. Implemente métodos
  para criar uma nova conta no banco de dados e verificar o
  saldo de uma conta;


- Realizar Transações: Implemente métodos para permitir
  que os clientes realizem transações, como depósitos e
  saques, atualizando o saldo da conta correspondente no
  banco de dados;


- Listar Transações: Crie uma funcionalidade para listar as
  transações realizadas em uma determinada conta;


- Listar Contas de um Cliente: Implemente um método para
  listar todas as contas de um cliente específico.