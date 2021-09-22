#!/bin/bash

echo "########Clean Build########"
./gradlew clean disTar

echo "########CreateDistributable########"
./gradlew createDistributable

echo "########Remove Birthcertificate########"
docker rm birthcertificate

echo "########Docker build########"
docker build --tag=birthcertificate-server:latest .

echo "########Docker run########"
docker run --name=birthcertificate -p8080:8080 birthcertificate-server:latest

echo "########Start Email Server########"
#docker rm epic_newton
#docker run -p 1080:1080 -p 1025:1025 maildev/maildev

