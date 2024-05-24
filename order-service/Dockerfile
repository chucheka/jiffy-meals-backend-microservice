FROM openjdk:21-jdk
MAINTAINER chikeucheka@gmail.com,sophyjelly718@gmail.com
ARG JAR_FILE=target/order-service.jar
WORKDIR /opt/app
COPY ${JAR_FILE} order-service.jar
ENTRYPOINT ["java","-jar","order-service.jar"]
