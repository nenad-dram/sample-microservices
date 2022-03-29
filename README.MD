# Demo Project - Microservices with Spring Boot and Spring Cloud

A simple project for practicing microservice-based architecture and Spring Cloud features.  
Inspired by the following project: https://github.com/piomin/sample-spring-microservices-new

## Tech Stack

Spring Cloud (Gateway, Config, Netflix Eureka, OpenFeign, Sleuth), Spring Boot, Maven, Docker

## Architecture

The project consists of the following modules:
- **gateway-service** - a module that uses Spring Cloud Gateway for running Spring Boot application that acts as a proxy/gateway in our architecture.
- **config-service** - a module that uses Spring Cloud Config for running configuration server in the `native` mode. The configuration files are placed on the classpath.
- **discovery-service** - a module that uses Spring Cloud Netflix Eureka as a discovery server.
- **employee-service** - a module containing the first simple microservice that allows to perform CRUD operation on in-memory repository of employees
- **department-service** - a module containing the second simple microservice that allows to perform CRUD operation on in-memory repository of departments. It communicates with employee-service via Spring Cloud OpenFeign. 
- **organization-service** - a module containing the third simple microservice that allows to perform CRUD operation on in-memory repository of organizations. It communicates with both employee-service and organization-service via Spring Cloud OpenFeign.

## Starting

The application can be started either standalone i.e. using the JAR files, or in a Docker containers (via Docker Compose).  
Details for both options are described in the separate sections below.  
After starting the API methods will be available at the same localhost ports.

 ### Standalone

To build JARs for all modules execute the command:
`$ ./mvnw clean package`  
To start the files execute for each module execute the command:
`$ java -jar ./module-name/target/module-name-*.jar`

 ### Docker

To build JARs for all modules execute the command:
`$ ./buildAll.sh` 

NOTE: All Docker images are using the layers from the fat JARs in order to improve build and start time of the image and the container.
 All dependencies are in one layer, whereas the code and the configuration is in another layer. 
 The shell script will first create the fat JARs and then the each JAR will be extracted into the corresponding `/target/layers` directory.

 To build and start all containers execute the command:
`$ docker compose up`

## Usage

After starting all available modules will be listed within the Eureka Server instance (http://localhost:8761/).  
Other modules will be available on the following ports:  
- **gateway-service: 8070**
- **department-service: 8081**
- **employee-service: 8080**
- **organization-service: 8082**

API examples (not the full API list):
- GET all employees: http://localhost:8070/employee/
- GET employee by ID: http://localhost:8070/employee/1
- GET organization by ID with departments: http://localhost:8070/organization/1/with-departments
- GET departments by organization ID and with employees: http://localhost:8070/department/organization/1/with-employees