#!/usr/bin/env zsh

in_hb_network=$(nslookup artifactory.shbmain.shb.biz | grep '^Aliases:' | wc -l)
if [[ in_hb_network -gt 0 ]]; then
        image=artifactory.shbmain.shb.biz/docker-registry-1.docker.io/ibmcom/websphere-liberty:latest
else
        image=icr.io/appcafe/websphere-liberty:latest
fi

cd "${0:A:h}"
docker run --rm -p 9443:9443 -p 9080:9080 -p 443:8443 -p 80:8080 -p 81:8081 --name websphere_liberty \
       --mount type=bind,src=$(pwd)/out/wlp,dst=/opt/ibm/wlp $image
