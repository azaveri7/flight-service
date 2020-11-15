#!/usr/bin/env bash
cd ..
docker build -t flight-service:latest .
docker tag flight-service:latest azaveri7/flight-service:external-1
docker push azaveri7/flight-service:external-1
