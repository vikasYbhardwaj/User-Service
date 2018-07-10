FROM openjdk:8
ADD ./User-Service-0.0.1-SNAPSHOT.jar User-Service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","User-Service.jar"]


