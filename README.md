# ATIVIDADE-DESENVOLVIMENTO-INTERNET-Thymeleaf-Spring-Boot-Bootstrap
Este projeto é uma aplicação Spring Boot que implementa um sistema de cadastro de alunos.  Ele utiliza o Spring MVC para expor rotas HTTP (como /alunos), o Spring Data JPA para acessar e manipular dados de um banco H2 em memória, e o Thymeleaf (ou endpoints REST) para exibir ou retornar as informações.
Ao iniciar o sistema, ele cria automaticamente uma tabela aluno no banco H2 com os campos:
id (chave primária)
nome
email
telefone

O objetivo principal é permitir:
Listar alunos cadastrados
Adicionar novos alunos
Atualizar ou excluir registros (dependendo do que foi implementado)
Visualizar os dados via navegador em http://localhost:8081/alunos
(Opcionalmente) acessar o console H2 em http://localhost:8081/h2-console


PASSO A PASSO

1- Execute o programa java, na main
2- Acesse no navegador http://localhost:8081/alunos
3- Selecione ‘’NOVO ALUNO’’ e digite o novo aluno
4- Se quiser, edite para mudar algo desse aluno
5- Acesse no navegador http://localhost:8081/h2-console 
6- Utilize como JDBC URL:  jdbc:h2:mem:alunodb
7- Utilize usuario como ‘’sa’’ e a senha vazia
8- Clique em connect
9- SELECT * FROM ALUNO para ver o banco de dados



