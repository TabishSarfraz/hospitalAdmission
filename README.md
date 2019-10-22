# hospitalAdmission


## Table of contents
* [Introduction](#introduction)
* [Technologies](#Technologies)
* [Setup](#Setup)
* [Build](#Build)
* [Run](#Run)


## Introduction
Hospital Admission CRUD Practice in Angular 8 and Java 8 with Spring Boot.

The purpose of this app is to store admissions into a hospital for patients.

Basically a CRUD application practice using RESTApi's to communicate with frontend and backend

Utlising programming languages and technologies:

- Angular 8 
- Java 8 
- Spring Boot (Framework)
- Spring JPA (Hibernate)
- MYSQL 





## Technologies
The application has been built using the following technologies:

- Angular 8   
- Java 8    
- Spring Boot
- Spring JPA
- Maven     - Dependency Management    


## Setup
### Prerequisite

- Java 8 (JDK 1.8)
- Maven 3.0.5
- MYSQL 8

To download JDK 1.8 please visit
```sh
https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
```

If you do not have maven please download it from
```sh 
https://maven.apache.org/download.cgi
```


### Database connection setup
Change the username and password to your local database account inside the application.properties file. 

It is located inside the main directory at
```
workspace\hospitalAdmissionGIT\backend\src\main\resources
```

## Build
To build the project, please navigate to the project root directory in command line and run the following command
```sh 
mvn clean install
```

## Run
The project can be run using .jar file or using maven command

### Running with .jar file
A .jar file is created under the 'target' folder inside the project root directory.

Use this command if your in the project root directory
```sh
java -jar target\.jar
```
Otherwise, navigate to the 'target' folder inside the project root directory and run
```sh
java -jar .jar
```

### Running using maven command
To run the project using maven command, go to the project root directory and run
```sh
mvn exec:java
```

