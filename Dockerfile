FROM gradle:7.6.1-jdk11-alpine
COPY . .
RUN gradle build
EXPOSE 8080
ENTRYPOINT ["java","-jar","build/libs/duodanzaclub-0.0.1-SNAPSHOT.jar"]