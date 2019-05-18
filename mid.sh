#!/bin/sh
echo "Starting Middleware Server"
sudo mvn spring-boot:run &
sudo mongoku start