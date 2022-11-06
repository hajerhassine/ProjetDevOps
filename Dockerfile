FROM openjdk:8
EXPOSE 8088
ADD /target/tpAchatProject-1.0.jar  DevopsProject-1.0.jar
ENTRYPOINT ["java", "-jar", "DevopsProject-1.0.jar"]