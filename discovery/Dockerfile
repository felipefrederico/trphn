FROM openjdk:11
LABEL maintainer="felipe.frederico@gmail.com"
VOLUME /tmp
EXPOSE 8081
ADD target/discovery.jar discovery.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/discovery.jar"]