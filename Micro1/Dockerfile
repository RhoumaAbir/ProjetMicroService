FROM openjdk:17
EXPOSE 8083
ADD target/Test-1.0-SNAPSHOT.jar test.jar
ENTRYPOINT ["java", "-jar", "test.jar"]