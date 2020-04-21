#!/bin/bash

# This script is ran on the Virtual Machine at: smithlu7@129.194.69.131
# It deploys the application 'Kernel' using 'helm install' or 'helm upgrade'

helm repo add hung-repo https://pinfo-2020.github.io/PInfo-4/
helm repo update

if helm list --all-namespaces -a | grep -q "fridge_hub"
then
  echo "fridge_hub exists"
  helm upgrade fridge_hub hung-repo/microservices
else
  echo "fridge_hub doesn't exist"
  helm install fridge_hub hung-repo/microservices
fi
