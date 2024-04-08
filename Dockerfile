
FROM openjdk:22-ea-21-slim-bullseye AS builder

WORKDIR /app
COPY . .

RUN mvn clean package

FROM openjdk:22-ea-21-slim-bullseye

COPY --from=builder /app/target/Spring1-0.0.1-SNAPSHOT.jar /app/Spring1-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "/app/Spring1-0.0.1-SNAPSHOT.jar"]
