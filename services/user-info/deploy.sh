#!/bin/bash

set -e

eval $(minikube docker-env)
docker build -t istio-demo/user-info:1.0.0 .
kubectl apply -f user-info.yaml
