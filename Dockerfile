# This pulls the latest JDK
FROM openjdk:latest
# Copies the self-contained JAR file into the Temp folder in the container.
COPY ./target/CorrieResit.jar /tmp
# Sets the current working directory context to the temp folder in the container
WORKDIR /tmp
# Executes the JAR file and maps the container to a docker internal container port 3306
ENTRYPOINT ["java", "-jar", "CorrieResit.jar", "database:3306"]
