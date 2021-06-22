FROM openjdk:8
EXPOSE 8083
ADD ./target/policy-service.jar policy-service.jar 
ENTRYPOINT ["java","-jar","/policy-service.jar"]