FROM openjdk:21-jdk
MAINTAINER chikeucheka@gmail.com,sophyjelly718@gmail.com
ARG JAR_FILE=target/identity-service-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} identity-service.jar
ENTRYPOINT ["java","-jar","identity-service.jar"]
