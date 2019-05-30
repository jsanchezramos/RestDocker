# Rest service to Docker

[![Coverage Status](https://coveralls.io/repos/github/jsanchezramos/RestDocker/badge.svg)](https://coveralls.io/github/jsanchezramos/RestDocker)

## Instructions

Build docker
```
docker build -t dockerrest .
```
Run docker
```
docker run -p 8080:8080 dockerrest
```
### Access REST API:
```
GET : http://0.0.0.0:8080/card
POST : http://0.0.0.0:8080/card
{
	"priceItem" : "10€",
	"nameItem" : "name of item"
}
```
Postman collection : https://www.getpostman.com/collections/8d1ccf323286bc2e7bb7
## Execute test
```
mvn test
```

OK
