FROM openjdk:8
ADD ./.../jars/User-Service-0.0.1-SNAPSHOT.jar User-Service.jar
EXPOSE 8080
ENTRYPOINT ["Java","-jar","User-Service.jar"]


