FROM openjdk:23-slim-bullseye AS builder

RUN apt-get update && apt-get install -y maven

WORKDIR /app
COPY . .

RUN mvn clean package

FROM openjdk:23-slim-bullseye

COPY --from=builder /app/target/Spring1-0.0.1-SNAPSHOT.jar /app/Spring1-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "/app/Spring1-0.0.1-SNAPSHOT.jar"]
