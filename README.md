# springapp

A RESTful Spring API 

## Prerequisites

A running instance of mysql.

For local development, a mysql instance can be brought up with `docker-compose`:

```
docker-compose up db
```

Alternatively, mysql can be brought up directly with docker:

```
docker run -d \
  --name mysql-springapp
  -e MYSQL_ROOT_PASSWORD=root \
  -e MYSQL_DATABASE=springapp \
  -p 3306:3306 \
  mysql:latest
```

## Running Application

Bring up a development version of the server with:

```
# if you have `make` installed
make dev-server
  
# if you don't have `make` installed
mvn spring-boot:run -Dspring.profiles.active=dev
```
