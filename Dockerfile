# okintern3-0.0.1-SNAPSHOT.jar

# Use the official OpenJDK base image for Java 17
FROM openjdk:17-oracle

ARG JAR_FILE=../build/libs/*.jar

# Set the working directory in the container
WORKDIR /app

# Copy the Spring Boot JAR file into the container
COPY ${JAR_FILE} app.jar

# Expose the application's port
EXPOSE 8080

# Define the command to run your Spring Boot application
CMD ["java", "-jar", "app.jar"]
