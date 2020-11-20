#!/usr/bin/env bash
cd ..
docker build -t flight-service:latest .
docker tag flight-service:latest azaveri7/microservices:flight-service
docker push azaveri7/microservices:flight-service