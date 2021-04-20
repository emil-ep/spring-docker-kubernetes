FROM java:8-jdk
COPY target/jukebox-*.jar jukebox.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "jukebox.jar"]
