#!/usr/bin/env zsh

cd "${0:A:h}"
docker run --rm -p 9443:9443 -p 9080:9080 -p 443:8443 -p 80:8080 --name websphere_liberty \
       --mount type=bind,src=$(pwd)/out/wlp,dst=/opt/ibm/wlp icr.io/appcafe/websphere-liberty:latest