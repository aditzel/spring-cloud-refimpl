# Spring Cloud Reference Implementation

This project is an exercise in building a Spring Boot + Spring Cloud + Netflix OSS based application using a microservice approach. It's a work in progress, so it will change over time. 

## Tech Stack

* Spring Boot 1.2.7 (See root pom.xml for explanations of why I'm not using a newer version of Spring Boot). 

## Development Environment Requirements

* Java 8
* Maven 3.3.1

## Project Structure

The project is broken out into multiple modules to mimick the way many organizations would have multiple projects, one 
each per microservice/microexperience. Hopefully the names are self descriptive, but just in case here is the breakdown:

* edge-server: This module is a Zuul based edge server. It uses Spring Cloud wrappers around core Zuul functionality and 
requires that a Eureka based microservice be running (see module service-discovery).
* poms/&#42;&#42;: This module is purely an organizational mechanism to contain parent poms that sub-module project can 
reference. Currently there is only poms/microservices/pom.xml, which is to be used by all modules that are a microservice/microexperience.
* service-discovery: This module is a Eureka based service discovery server. It uses the Spring Cloud wrappers around 
Eureka and does not require any other microservice to be running.

The above projects all have an embedded Hystrix dashboard enabled, available at http://localhost:&lt;port&gt;/hystrix, you can then 
enter http://localhost:&lt;port&gt;/hystrix.streams in the input fields to view the hystrix stats for that microservice.

## Building The Project

## Running The Project

## Credits

## License

https://opensource.org/licenses/MIT
