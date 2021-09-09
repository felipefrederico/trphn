FROM openjdk:11
LABEL maintainer="felipe.frederico@gmail.com"
VOLUME /tmp
EXPOSE 8082
ADD target/device.jar device.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/device.jar"]