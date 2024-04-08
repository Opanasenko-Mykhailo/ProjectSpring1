
FROM openjdk:22-ea-21-slim-bullseye
ARG JAR_FILE=target/Spring1-0.0.1-SNAPSHOT.jar

WORKDIR /app

COPY ${JAR_FILE} app.jar

CMD ["java", "-jar", "app.jar"]