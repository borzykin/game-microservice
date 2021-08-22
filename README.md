# Game microservice, designed to work with [User microservice](https://github.com/borzykin/user-microservice/)  

Prerequisite: 
- Postgres DB in AWS RDS is running (tables will be created by sql init scripts)

This is basically Spring Boot Rest Api app which contains some basic API endpoints to GET, ADD games for users and save them in the PostgresDB.  
Purpose of this project is to create some kind of ELO rating calc API to learn and play with:   
- Spring boot
- Postgres 
- Lombok
- Unit tests
- Mockito
- Spring WebClient (in the Game microservice only)
- Swagger docs
