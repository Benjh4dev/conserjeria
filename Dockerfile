# Stage 1: Build the application
FROM gradle:8.3-jdk17 AS build

WORKDIR /usr/app

COPY . .

RUN gradle shadowJar --no-daemon

# Stage 2: Setup the final container
FROM openjdk:17-jdk

# Copy the built jar file from the build stage to the final container
COPY --from=build /usr/app/build/libs/*.jar /app.jar

# Run the jar file
CMD ["java", "-jar", "/app.jar"]
