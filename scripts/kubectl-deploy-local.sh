#!/usr/bin/env bash
kubectl delete -f deploy-flight.yaml
kubectl create -f deploy-flight.yaml
kubectl port-forward svc/flight-service-svc 8081:8081
