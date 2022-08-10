FROM openjdk:11 as build
RUN mkdir -p /app
WORKDIR /app
ADD build/libs/*.jar /app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]