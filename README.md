# DBC - Ticket: João Reis Jr
Projeto teste para a empresa Ticket: Persistir dados de "cidade" / "estado", considerando suas regras de negócios respectivas, disponibilizando insert em batch e apresentando uma single page no front-end com comportamento também definido pela prova prática designada.
        
        Certifique-se de primeiro ter instalado e configurado as tecnologias seguintes em seu ambiente: 
        Java, Maven, Maven-Wrapper, Npm (ou Yarn) e em sua IDE o Plugin Lombok.
        
Para Rodar Local:
---------------------            
A) Rodar Back-End: (http://localhost:8080)
* Diretamente via pacote Java: ` java -jar .\target\DBCjreis-0.0.1-SNAPSHOT.jar`.
* Ou via  wrapper: `{pasta raiz do projeto}> mvn -N io.takari:maven:wrapper` e então `mvnw clean spring-boot:run`.
---------------------
B) Rodar Front-End: (http://localhost:3000)
* Terminal: `{pasta raiz do projeto}> cd .\src\main\webapp\singlepage`,  `npm[ou yarn] install` e então `npm[ou yarn] start`

* Para visualizar o database: `http://localhost:8080/h2-console`, database: `jdbc:h2:mem:testedb` login `admin` senha `admin` 

* API's (Swagger): `http://localhost:8080/swagger-ui.html#/`

Tecnologias usadas:
 ReactJS / Bootstrap / H2 /
 SpringBoot / Maven / JPA / Swagger / Lombok \
 \
Observações: Parte das implementações finais não constam devido o tempo (fiz no fim de semana). 
-----------------
 João Robson Reis Jr\
 Senior Developer
 
 15/03/2020
