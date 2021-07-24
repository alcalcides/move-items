FROM openjdk:11

ARG JAR_FILE=target/*.jar

WORKDIR /

COPY ${JAR_FILE} app.jar
COPY config.json .

ENTRYPOINT ["java","-jar","/app.jar"]
 