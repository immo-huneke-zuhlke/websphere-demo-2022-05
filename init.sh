#!/usr/bin/env zsh

cd "${0:A:h}"
docker run --rm --name websphere_liberty icr.io/appcafe/websphere-liberty:latest &
sleep 15
rm -rf out
mkdir out
docker cp websphere_liberty:/opt/ibm/wlp out/
./stop.sh