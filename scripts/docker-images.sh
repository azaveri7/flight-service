#!/usr/bin/env bash
cd ..
docker build -t flight-service:latest .
docker tag flight-service:latest azaveri7/flight-service:svc
docker push azaveri7/flight-service:svc
