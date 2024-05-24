FROM openjdk:21-jdk-alpine
WORKDIR /jiffy-meals-backend-microservice-app
COPY jiffy-meals-backend-microservice /jiffy-meals-backend-microservice-app
EXPOSE 8080
CMD ["java", "-jar", "micro/order-service/target/order-service-0.0.1-SNAPSHOT.jar"]
