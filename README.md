# Rest service to Docker
## Instructions

Build docker
```
docker build -t dockerrest
```
Run docker
```
docker run -p 8080 dockerrest
```
Access web:
```
GET : http://0.0.0.0:8080/card
POST : http://0.0.0.0:8080/card
{
	"priceItem" : "10€",
	"nameItem" : "esto es un nmnre"
}
```
## Execute test
```
mvn test
```
