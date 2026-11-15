# Stage 1: Build the application
FROM gradle:9.8.2-jdk21 AS build

WORKDIR /app

COPY . .

RUN gradle clean bootJar --no-daemon

# Stage 2: Run the application
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 9001

ENTRYPOINT ["java", "-jar", "app.jar"]