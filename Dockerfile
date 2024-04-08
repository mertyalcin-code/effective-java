# Use the official Ubuntu image as the parent image
FROM ubuntu:latest AS build
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk maven

# Set the working directory in the Docker container
WORKDIR /app

# Copy the Maven project into the Docker container
COPY . .

# Use Maven to package the Java application into a JAR file
RUN mvn package -DskipTests

# Use the official OpenJDK image to run the compiled JAR file
FROM openjdk:17-jdk-slim
EXPOSE 8098

# Copy the JAR file from the build stage into the /app directory of the new container
COPY --from=build /app/target/*.jar app.jar

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
