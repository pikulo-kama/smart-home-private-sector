FROM maven:3.6.3-jdk-11 as BUILD

WORKDIR /workspace
COPY . .
RUN mvn -f pom.xml clean package -DskipTests

FROM openjdk:11-jre-slim
COPY --from=BUILD /workspace/target/*.jar app.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]