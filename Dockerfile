FROM openjdk:17-oracle
COPY "./target/api-rest-webflux-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]