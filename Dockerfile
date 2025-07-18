# Use Eclipse Temurin base image for Java 24 (official build)
FROM eclipse-temurin:24-jdk AS build

# Set workdir
WORKDIR /app

# Copy all files
COPY . .

# Make sure the mvnw script is executable (important!)
RUN chmod +x mvnw

# Build the application with Maven Wrapper
RUN ./mvnw clean package -DskipTests

# -------------------
# Production image
# -------------------

# Use a small JRE runtime image for Java 24
FROM eclipse-temurin:24-jre

# Set workdir
WORKDIR /app

# Copy the jar from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port (adjust if needed)
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
