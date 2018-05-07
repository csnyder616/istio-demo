#!/bin/bash

set -e

eval $(minikube docker-env)

docker build -t istio-demo/homepage:1.0.0 .
kubectl apply -f homepage.yaml
