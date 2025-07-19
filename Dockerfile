# -------------------
# Build stage
# -------------------
FROM eclipse-temurin:24-jdk AS build

WORKDIR /app

COPY . .

RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests


# -------------------
# Production runtime
# -------------------
FROM eclipse-temurin:24-jre

WORKDIR /app

# 🟢 Install CA certs for Atlas TLS
USER root
RUN apt-get update && apt-get install -y ca-certificates && update-ca-certificates

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
