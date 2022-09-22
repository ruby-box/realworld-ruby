FROM adoptopenjdk/openjdk11
WORKDIR /app
ADD build/libs/spring-boot-realworld-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]