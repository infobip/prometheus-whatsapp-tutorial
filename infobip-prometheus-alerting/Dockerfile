# Stage 1, builds maven project in a large JDK based image
FROM maven:3.9-eclipse-temurin-21-jammy as build-stage
WORKDIR /opt/infobip-prometheus-alerting
COPY pom.xml .
RUN mvn dependency:go-offline -U
COPY ./src ./src
RUN mvn clean package -Dmaven.test.skip=true

# Stage 2, creates a JRE based image with compiled app
FROM eclipse-temurin:21-jammy
WORKDIR /opt/infobip-prometheus-alerting
COPY --from=build-stage /opt/infobip-prometheus-alerting/target/infobip-prometheus-alerting-0.0.1-SNAPSHOT.jar ./infobip-prometheus-alerting-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "infobip-prometheus-alerting-0.0.1-SNAPSHOT.jar"]