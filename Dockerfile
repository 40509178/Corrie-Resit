FROM openjdk:latest
COPY ./target/Corrie-Resit.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "Corrie-Resit.jar", "database:3306"]
