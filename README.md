# Spring Data MongoDB Demo

### Description

A demo Spring Boot application that uses Spring Data MongoDB for interacting with the MongoDB document store. The project simply exposes
a ``MongoRepository`` via a REST endpoints, so any CRUD operation can be performed with the exposed endpoints. The project is written in Java 11 and
uses Gradle as build and dependency management tool. The project tech stack is:

```
  Java              11
  Spring Boot       2.3.4
  Lombok            1.18.10
  Gradle            6.6.1
```

### Building the project

In order to build the project, the following Gradle command has to be executed:

```
./gradlew clean build
```

### Starting the application

The Spring Boot application can be started with the following Gradle command:

```
./gradlew bootRun
```

The application will be started at port **8080** under the context root **/**. The following CRUD endpoints will be available:

* POST http://localhost:8080/persons
* GET http://localhost:8080/persons
* GET http://localhost:8080/persons/{id}
* PUT http://localhost:8080/persons/{id}
* DELETE http://localhost:8080/persons
