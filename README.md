# T2731

These are the lab files and solutions for the T2731 java training course.
Download or clone this repo to your computer.

## Requirements
Java 17 JDK and either Eclipse or Intellij

## Installing the JDK
Go to https://adoptium.net/ and download the latest LTS for your OS.

## Eclipse
Start Eclipse and set the repo folder as your workspace.
Configure Eclipse to use the jdk17 SDK runtime in Preferences

## Intellij IDEA
Start IntelliJ IDEA and open either Example or Solutions folders as maven projects

## Projects
* Examples - starting point of the exercises and example code
* Solutions - suggested solutions to the exercises
* SpringBootJpaDemo - see below

## Spring Boot
Spring Boot is platform for building self contained applications.
It is built on top of Spring Framework and commonly used to build web applications and APIs (Spring MVC).

Learn more at https://spring.io

JPA is the Java Persistence Api, it is high level api data access based on object/relational mapping. 
Spring Data JPA adds an additional layer of abstraction (CrudRepository) on top of JPA.

The maven project skeleton was generated at https://starter.spring.io
with the Spring Web, Spring Data JPA dependencies and H2 database dependencies.

To understand the demo code, read through the following guides:

* https://spring.io/guides/gs/accessing-data-jpa/
* https://spring.io/guides/gs/rest-service/
