# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the maintainer label
LABEL maintainer="nftalemarega080@gmail.com"

# Set the working directory in the container
WORKDIR /app

# Copy the jar file into the container
ARG JAR_FILE=target/*.jar

# Copy the jar file
COPY ${JAR_FILE} app.jar

# Expose the port the application runs on
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
