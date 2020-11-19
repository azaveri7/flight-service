#!/usr/bin/env bash
aws ecr get-login-password --region us-east-2 | docker login --username AWS --password-stdin 615360450654.dkr.ecr.us-east-2.amazonaws.com
cd ../..
docker build -t flight-service:latest  --file DockerfileAWS .
docker tag flight-service:latest 615360450654.dkr.ecr.us-east-2.amazonaws.com/flight-service:latest
docker push 615360450654.dkr.ecr.us-east-2.amazonaws.com/flight-service:latest