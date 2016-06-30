# Hello Dockerfile
# Version: ?

FROM java:8

WORKDIR /

USER daemon

ENTRYPOINT ["java", "-jar", "/opt/hello.jar"]

EXPOSE 8080

COPY target/scala-2.11/hello-docker_2.11-0.1.jar /opt/hello.jar

