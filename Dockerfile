FROM openjdk:17-jdk-slim
WORKDIR /app
COPY build/libs/user-microservice-*.jar app.jar
EXPOSE ${PORT}
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "app.jar"]