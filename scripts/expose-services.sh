#!/bin/bash

kubectl port-forward -n istio-system $(kubectl get pod -n istio-system -l app=servicegraph -o jsonpath='{.items[0].metadata.name}') 8088:8088 > /dev/null &
kubectl port-forward -n istio-system $(kubectl get pod -n istio-system -l app=prometheus -o jsonpath='{.items[0].metadata.name}') 9090:9090 > /dev/null &
kubectl port-forward -n istio-system $(kubectl get pod -n istio-system -l app=grafana -o jsonpath='{.items[0].metadata.name}') 3000:3000 > /dev/null &

