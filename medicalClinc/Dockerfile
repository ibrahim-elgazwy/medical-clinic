FROM maven:3.8.6-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -Dmaven.test.skip=true -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/medicalclinc-0.0.1-SNAPSHOT.jar /usr/local/lib/medicalclinc.jar
EXPOSE 8089
ENTRYPOINT ["java","-jar","/usr/local/lib/medicalclinc.jar"]