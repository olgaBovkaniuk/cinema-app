# cinema-app

## 1. How to install

### 1.1 Setup `WEB-APP` application properties

location:
```
/cinema-web-app/src/main/resources/application.properties
```

required properties (by default is):

```
server.port=8085
spring.datasource.url=jdbc:postgresql://localhost:5432/cinema
spring.datasource.username=postgres
spring.datasource.password=1234
```

### 1.2 Setup `LIQUIBASE` properties

location:
```
/liquibase/liquibase.properties
```

requred properties (by default is):
```
url: jdbc:postgresql://localhost:5432/cinema
username: postgres
password: 1234
```
NOTE: Create database `cinema` before running clean install:
CREATE DATABASE cinema;

### 1.3 Go to project parent dir ( `cinema` ) and execute command
```
mvn clean install
```

### 1.4 Run spring boot app
```
cd cinema-web-app 
mvn spring-boot:run
```
