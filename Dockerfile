FROM openjdk:8-jdk-alpine
EXPOSE 8086
ADD target/tpAchatProject-1.0.jar tpAchatProject.jar
ENTRYPOINT ["java","-jar","tpAchatProject.jar"]