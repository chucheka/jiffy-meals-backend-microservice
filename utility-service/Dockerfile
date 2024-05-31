FROM openjdk:21-jdk
MAINTAINER chikeucheka@gmail.com,sophyjelly718@gmail.com
ARG JAR_FILE=target/utility-service-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} utility-service.jar
ENTRYPOINT ["java","-jar","utility-service.jar"]
