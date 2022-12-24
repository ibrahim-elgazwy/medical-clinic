FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home2/app/src
COPY pom.xml /home2/app
RUN mvn -Dmaven.test.skip=true -f /home2/app/pom.xml clean install package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home2/app/target/eurkaserver-0.0.1-SNAPSHOT.jar /usr/local/lib/eurkaserver.jar
EXPOSE 8070
ENTRYPOINT ["java","-jar","/usr/local/lib/eurkaserver.jar"]