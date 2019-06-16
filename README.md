# springapp

A RESTful Spring API to manage social operations such as handling users and their friendships.

## Prerequisites

A running instance of mysql. By default, the app is configured to connect to a local mysql instance listening on port 3306 with a schema of `springapp`, and the user:password credentials of `root:R00tiest-`.  

For local development, a mysql instance with this configuration can be brought up with `docker-compose`:

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

To connect via a different configuration to your mysql instance simply update the appropriate `application.properties` file.


## Running Application

Bring up a development version of the server with:

```
# if you have `make` installed
make dev-server
  
# if you don't have `make` installed
mvn spring-boot:run -Dspring.profiles.active=dev
```

## Documentation

### Javadoc

Generated javadoc documentation for the codebase is hosted [here](https://damienomurchu.github.io/springapp/).

### API documentation

API documentation provided via SwaggerUI is coming!  