#!/bin/bash

set -e

eval $(minikube docker-env)
docker build -t istio-demo/newsfeed:1.0.0 .
kubectl apply -f newsfeed.yaml
