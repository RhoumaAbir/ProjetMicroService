
FROM openjdk:17-jdk-slim

COPY target/Gateway-0.0.1-SNAPSHOT.jar /app/Gateway-0.0.1-SNAPSHOT.jar

EXPOSE 8091

ENTRYPOINT ["java", "-jar", "/app/Gateway-0.0.1-SNAPSHOT.jar"]
