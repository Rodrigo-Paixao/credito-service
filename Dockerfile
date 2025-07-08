FROM eclipse-temurin:11-jdk

WORKDIR /app

COPY build/libs/credito-service-*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]

