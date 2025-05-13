FROM openjdk:17-jdk-slim
WORKDIR /app
COPY . /app
COPY target/bmi-web-app-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "target/bmi-1.0.0.jar"]
