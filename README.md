## City Connect
City Connect service is built to check connectivity between cities. It is developed using spring boot.

## Prerequisites
To run this service, we need to have the below
> 1. Java Version >= 8
> 2. Maven 
 
## Components

> - Spring Boot
> - Spring REST API
> - Swagger API Documentation
> - Actuator for health, info and monitoring metrics 

## Running the Service
Import the project into IntelliJ and start the service using Run Configuration.
 
## Testing
The API can be tested from browser/Postman
Browser URL:
```
http://localhost:8080/city-connect?origin=Miami&destination=Tampa
```
For POSTMAN or Command line:
```
curl -X GET 'http://localhost:8080/city-connect?origin=Miami&destination=Tampa'
```
## Swagger UI
```
http://localhost:8080/swagger-ui.html
```

## Actuator Endpoints
Health Check
```
http://localhost:8080/actuator/health
```

All available Actuator endpoints can be accessed here:
```
http://localhost:8080/actuator/
```

## TODOs
> - Dockerize the App & publish the image to AWS ECR repository
> - Version the App & Have build CICD pipeline to build & deploy
> - Implemented Logging using log4j & have proper log rotation policy
> - Ship log to S3 using logrotate service
