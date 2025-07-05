# Use official OpenJDK base image
FROM eclipse-temurin:21-jre-alpine

# Set the working directory
WORKDIR /app

# Copy built jar (adjust as needed)
COPY target/*.jar app.jar

# Set the Spring profile for Docker
ENV SPRING_PROFILES_ACTIVE=docker

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]