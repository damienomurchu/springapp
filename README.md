# springapp

A RESTful Spring API 

## Prerequisites

A running instance of mysql.

For local development, a mysql instance can be run via:
```
docker run --name mysql-springapp -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=springapp -d -p 3306:3306 mysql:latest

```

## Running Application

```
mvn spring-boot:run -Dspring.profiles.active=dev
```