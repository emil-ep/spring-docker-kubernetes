FROM arm64v8/openjdk:8
RUN mkdir /app
RUN cd /app
COPY target/jukebox-0.0.1-SNAPSHOT.jar /app/jukebox.jar
COPY config/production.properties /app/application.properties
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "jukebox.jar", "--spring.config.location=application.properties"]
