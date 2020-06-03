# spring-kotlin-crud

To run this project, follow these steps:

* Run the application database by executing `docker-compose up` in src/test/resources directory.
* Launch the Spring Boot Application (ApplicationRunner). 
* By default, the application will connect to the database(MySQL) (configuration in *application.properties*)


Run the following command in your terminal:
```shell script
curl --location --request POST 'http://localhost:8080/todo/' \
--header 'Content-Type: application/json' \
--data-raw 'Hello World'
```
