# Use a base image for Java
FROM eclipse-temurin:17-jdk

# Set the working directory in the container
WORKDIR /app

# Copy only the necessary files for Maven to resolve dependencies
COPY pom.xml ./
COPY .mvn ./.mvn
COPY mvnw ./

# Run Maven dependency resolution
RUN ./mvnw dependency:go-offline -B

# Copy the application source code
COPY src ./src

# Package the application
RUN ./mvnw package -DskipTests

# Expose the application port
EXPOSE 8081

# Define the entry point for the application
ENTRYPOINT ["java", "-jar", "target/chicken-0.0.1-SNAPSHOT.jar"]
