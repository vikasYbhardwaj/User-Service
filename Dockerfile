FROM openjdk:8
<<<<<<< HEAD
ADD ./User-Service-0.0.1-SNAPSHOT.jar User-Service.jar
=======
ADD ./.../jars/User-Service-0.0.1-SNAPSHOT.jar User-Service.jar
>>>>>>> 4456e2ec41a377418534b49ff0e5441bae7e1385
EXPOSE 8080
ENTRYPOINT ["java","-jar","User-Service.jar"]


