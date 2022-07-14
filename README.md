# Sistema de Gestão de Vila

### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina a seguintes ferramentas:
[Eclipse Spring Tools](https://spring.io/tools),
[RabbitMQ](https://www.rabbitmq.com/#getstarted),
[Postgres](https://www.postgresql.org/download/).

### 🎲 Rodando a api (Back End)

🚧 Em construção... 🚧

```bash
# Clone este repositório
$ git clone https://github.com/howjack/SPRING-DEVINHOUSE.git

# Acesse a pasta do projeto

# Abra a pasta com o spring tools

# Modele seu banco de dados com os conteudos do sql que estão no arquivo DB_VilaAcate na pasta Modelagem.

# Modelagem de mensageria na pasta Modelagens

# Execute a aplicação

# Use esses endpoints abaixo para ler, criar ou deletar os habitantes do banco.
Criar habitante - http://localhost:8080/vilacate/add
Listar todos os habitantes - http://localhost:8080/vilacate/list
Listar habitante por ID - http://localhost:8080/vilacate/get/1
Listar habitante por Nome - http://localhost:8080/vilacate/list/name?nome=p
Listar habitante por mes de aniversario - http://localhost:8080/vilacate/list?mes=6
Listar habitante por ano de idade e superior - http://localhost:8080/vilacate/list/age?idade=22
Mostrar relatorio financeiro da vila e a maior renda entre os habitantes - http://localhost:8080/vilacate/rent
Deletar habitante - http://localhost:8080/vilacate/delete/19

# A renda da vila é alterada no aplication.properties
```
