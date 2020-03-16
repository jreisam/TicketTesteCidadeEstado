# DBC - Ticket: João Reis Jr
Projeto teste para a empresa Ticket: Persistir dados de "cidade" / "estado", considerando suas regras de negócios respectivas, disponibilizando insert em batch e apresentando uma single page no front-end com comportamento também definido pela prova prática designada.
        
         
        
Para Rodar Local:
---------------------            
A) Rodar Back-End: (http://localhost:8080)
* Rodar Back-End: Em um Terminal: `{pasta raiz do projeto}> mvn -N io.takari:maven:wrapper` e então `mvnw clean spring-boot:run`.
* Ou rodar Back-End Build: `{pasta raiz do projeto}> mvn package` e então ` java -jar .\target\DBCjreis-0.0.1-SNAPSHOT.jar`.
---------------------
B) Rodar Front-End: (http://localhost:3000)
* Em outro Terminal: `{pasta raiz do projeto}> cd .\src\main\webapp\singlepage`,  `yarn install` e então `yarn start`

* Para visualizar o database: `http://localhost:8080/h2-console`, database: `jdbc:h2:mem:testedb` login `admin` senha `admin` 

* API's (Swagger): `http://localhost:8080/swagger-ui.html#/`

Tecnologias usadas:
 ReactJS / Bootstrap
 H2
 SpringBoot / Maven / JPA / Swagger / Lombok \
 \
Observações: Foi feito todo o possível nos dois dias que tive disponíveis para a tarefa, algumas implementações não constam devido a isso, e a aplicação back-end + front-end também só não estão rodando juntas devido mesmo motivo. Agradeço desde já a oportunidade.
-----------------
 João Robson Reis Jr\
 Senior Developer
 
 15/03/2020