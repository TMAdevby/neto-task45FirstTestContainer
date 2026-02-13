FROM eclipse-temurin:21-jre-alpine

EXPOSE 8080

COPY target/neto-task45FirstTestContainer-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]