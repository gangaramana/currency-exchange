FROM openjdk:8
EXPOSE 8100
ADD target/currency-exchange-service-docker.jar currency-exchange-service-docker.jar
ENTRYPOINT ["java","-jar","/currency-exchange-service-docker.jar"]