FROM openjdk:21-jdk
MAINTAINER chikeucheka@gmail.com,sophyjelly718@gmail.com
ARG JAR_FILE=target/stock-service-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} stock-service.jar
ENTRYPOINT ["java","-jar","stock-service.jar"]
