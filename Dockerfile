#
# Build stage
#
FROM gradle:jdk17-jammy AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

LABEL org.name="gug33435"
#
# Package stage
#
FROM eclipse-temurin:17-jdk-jammy
COPY --from=build /*.jar app.jar
ENTRYPOINT ["java", "-jar","/app.jar"]