FROM openjdk:17-alpine
EXPOSE 8082
ADD target/client-0.0.1-SNAPSHOT.jar client-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/client-0.0.1-SNAPSHOT.jar"]