FROM openjdk:8
EXPOSE 8100
ADD target/docker-conversion-service.jar docker-conversion-service.jar
ENTRYPOINT ["java","-jar","/docker-conversion-service.jar"]