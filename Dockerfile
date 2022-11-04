FROM openjdk:8-jdk-alpine
RUN apk --no-cache add curl
RUN curl -u admin:nexus -o tpAchatProject-1.0.jar "http://192.168.162.222:8081/repository/maven-releases/	com/esprit/examen/tpAchatProject/1.0/tpAchatProject-1.0.jar" -L
ENTRYPOINT ["java","-jar","/tpAchatProject-1.0.jar"]
EXPOSE 8089