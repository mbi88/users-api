FROM gradle:4.7-jdk8-alpine AS builder
ADD . /code
WORKDIR /code
USER root
RUN gradle clean build --no-daemon --console plain

FROM openjdk:8-jre-alpine
COPY --from=builder /code/build/libs/users-api-1.0.jar /application/
EXPOSE 8080/tcp
CMD java -Dserver.port=8080 -jar /application/users-api-1.0.jar