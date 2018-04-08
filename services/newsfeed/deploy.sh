#!/bin/bash

set -e

eval $(minikube docker-env)
docker build -t newsfeed .
kubectl run newsfeed --image=newsfeed:latest --port=80 --image-pull-policy='Never'
kubectl expose deployment newsfeed --type=NodePort
curl $(minikube service --url newsfeed)/newsfeed/1
