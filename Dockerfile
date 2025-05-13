FROM maven:3.8.6-openjdk-17 AS build
WORKDIR /app

# Copy the entire project and build it
COPY . .
RUN mvn clean package -DskipTests

# Final image for running
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/bmi-web-app-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
