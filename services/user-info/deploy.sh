#!/bin/bash
eval $(minikube docker-env)
docker build -t user-info .
kubectl run user-info --image=user-info:latest --port=8080 --image-pull-policy='Never'
kubectl expose deployment user-info --type=NodePort
curl $(minikube service --url user-info)/user-info/1
