FROM openjdk:17-jdk-alpine
MAINTAINER frakit.de
#COPY build/libs/birthcertificate-0.0.1.jar birthcertificate-0.0.1.jar
#ENTRYPOINT ["java","-jar","/birthcertificate-0.0.1.jar"]

ENV JAVA_TOOL_OPTIONS="-Dfile.encoding=UTF-8 -XX:MinRAMPercentage=60.0 -XX:MaxRAMPercentage=90.0"
WORKDIR /app
EXPOSE 8080

ADD /dist/birthcertificate.tar /app
CMD exec /app/birthcertificate*/bin/birthcertificate