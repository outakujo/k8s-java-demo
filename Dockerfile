FROM maven:3.8.7-openjdk-18 as build

WORKDIR /usr/src/myapp

COPY . .

RUN mvn package -s settings.xml

FROM openjdk:18

WORKDIR /opt/app

COPY --from=build /usr/src/myapp/target/server.jar /opt/app/server.jar

ENTRYPOINT ["java", "-jar", "server.jar"]
