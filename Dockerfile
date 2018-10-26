FROM openjdk:8-jdk-alpine
MAINTAINER Nils Schwinning
COPY target/alexa-0.0.1-SNAPSHOT.jar /home/app.jar
CMD ["java","-jar","/home/app.jar"]