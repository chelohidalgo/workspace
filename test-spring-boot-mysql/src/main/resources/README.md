# Spring Boot with AngularJS 

This is sample Spring Boot Single Page Application using Angular. 

### Prerequisites
- [JDK 1.8]
- [Spring Tool Suite]
- [MySql]

### How to run 

  - Import/Open the project. 
  - Open command prompt and put mvn clean install -Dmaven.test.skip=true
		The unit test must be done one by one, and following an order
  
  - File **application.properties** has database properties for [MySql] database. Also create a databse with name you have specified in **application.properties**. In this app I have named database as library.
  - Open **Application.java** and Run as **Java Application**. This will start the application and you can check on http://localhost:8080
  - Once application started, you can login with provided credentials on index page.

### What this project coantains

This Spring boot web project has implementaion of simple CRUD operation of User,Store and Employee entities. The implementaion is based on Angular JS. So for User entity, there is a seperate folder called user under **src/main/resources/**. 
This folder has controllers, services, directives and templates related to User module.


### Update 25th May 2016
Added Spring Security (database authentication) and AuditorAware to track who edited/added entity. Most of the code related to Spring Secuty has been taken from [jhipster-sample-app].

### Reference


[Spring Boot]: http://projects.spring.io/spring-boot/
[Spring Data JPA]: http://projects.spring.io/spring-data-jpa/
[MySql]: https://www.mysql.com/
[Spring Tool Suite]:https://spring.io/tools
[JDK 1.8]: http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
[MySql]: https://www.mysql.com/