FROM openjdk:18
WORKDIR /usr/src/myapp
COPY ./target/demo-0.0.1-SNAPSHOT.jar ./app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]