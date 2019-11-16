#FROM java:8
#FROM maven:alpine
#
#WORKDIR /app
#
#COPY . /app
#
#RUN mvn -v
#
#RUN mvn clean install -DskipTests
#
#EXPOSE 80
#
#ENTRYPOINT ["java","-cp","app:app/lib/*","leavemanagament.LeaveManagamentApplication"]

FROM openjdk:10-jre-slim
FROM maven:3.6.2-jdk-11-openj9

WORKDIR /usr/src/app

COPY . /usr/src/app
RUN mvn clean install -DskipTests

EXPOSE 80

CMD ["java", "-jar", "target/LeaveManagament-1.0-SNAPSHOT.jar"]