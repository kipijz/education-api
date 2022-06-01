# 🏫 Education REST API

REST API made with Java, Spring Boot and H2.       

Can store Tutors, Courses and Students. As well as can fetch Students and their Courses and their Tutors.

## How to run

* Application address - http://localhost:8080/.
* Java 17 and Maven have to be installed.
```
mvn spring-boot:run
```

## REST APIs Endpoints
### Add a Tutor

* /add-tutor [PUT]

### Add a Course

* /add-course [PUT]

### Add a Student

* /add-student/{courseName} [PUT]

### Get Student by ID

* /get-student/{id} [PUT]

For more details, visit http://localhost:8080/swagger-ui/index.html#/. 

## H2 Database

Available at:
```
localhost:8080/h2-console/
```
Access it by entering the following information:

![h2 console](https://i.imgur.com/MlYVcJl.png)

## Improvements in the future
* Integration testing



