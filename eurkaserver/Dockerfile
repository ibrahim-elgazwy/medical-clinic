#Start with a base image containing Java runtime
FROM openjdk:11-slim as build

#Information around who maintains the image
MAINTAINER medicalclinic.com

# Add the application's jar to the container
COPY target/eurkaserver-0.0.1-SNAPSHOT.jar eurkaserver-0.0.1-SNAPSHOT.jar

#execute the application
ENTRYPOINT ["java","-jar","/eurkaserver-0.0.1-SNAPSHOT.jar"]