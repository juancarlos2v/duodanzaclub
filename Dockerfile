FROM gradle:7.6.1-jdk11-alpine
COPY . .
RUN gradle build
EXPOSE 8090
ENTRYPOINT ["java","-jar","build/libs/duodanzaclub-0.0.1-SNAPSHOT.jar"]