# Use the latest MySQL images
FROM mysql
# Set the working directory
WORKDIR /tmp
# Copy the main SQL file to docker-entrypoint-initdb.d.
# Scripts and SQL files in this folder are executed on container startup.
# This is specific to MySQL.
COPY world_database/world.sql /docker-entrypoint-initdb.d
# Set the password for the "root" user.  This is not a recommended practice, it is standard practice to remove the root user as part of basic security measures
ENV MYSQL_ROOT_PASSWORD example
