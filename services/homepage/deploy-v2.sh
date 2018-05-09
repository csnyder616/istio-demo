#!/bin/bash

set -e

eval $(minikube docker-env)

docker build -t istio-demo/homepage:2.0.0 .
kubectl apply -f homepage-v2.yaml
