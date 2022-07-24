FROM openjdk:latest
COPY ./target/CorrieResit.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "CorrieResit-1.0-SNAPSHOT.jar", "database:3306"]
