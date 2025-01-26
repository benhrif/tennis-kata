
FROM openjdk:21-jdk-slim


WORKDIR /app


COPY target/tennis-0.0.1-SNAPSHOT.jar /app/tennisGameApp.jar


ENTRYPOINT ["java", "-jar", "/app/tennisGameApp.jar"]