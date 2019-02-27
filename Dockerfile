FROM maven:3-jdk-8-alpine AS build

WORKDIR /app

# Copy everything else and build
COPY . ./

RUN mvn package
RUN mkdir /app/out && mv ./target/jetty-webservice-1.0-SNAPSHOT.jar /app/out/jetty-webservice-1.0-SNAPSHOT.jar

# Runtime image
FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=build /app/out .

EXPOSE 80

ENTRYPOINT ["java", "-jar", "jetty-webservice-1.0-SNAPSHOT.jar"]