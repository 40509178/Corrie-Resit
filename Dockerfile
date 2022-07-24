FROM openjdk:latest
COPY ./target/Corrie-Resit-1.0-SNAPSHOT.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "Corrie-Resit-1.0-SNAPSHOT.jar", "database:3306"]
