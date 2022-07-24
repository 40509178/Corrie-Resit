FROM openjdk:latest
COPY ./target/CorrieResit.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "CorrieResit.jar", "database:3306"]
