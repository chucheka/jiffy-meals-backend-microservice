FROM openjdk:21-jdk
MAINTAINER chikeucheka@gmail.com,sophyjelly718@gmail.com
ARG JAR_FILE=/var/lib/jenkins/workspace/micro@2/config-server/target/config-server-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} config-server.jar
ENTRYPOINT ["java","-jar","config-server.jar"]
