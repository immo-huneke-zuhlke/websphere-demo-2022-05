#!/usr/bin/env zsh

in_hb_network=$(nslookup artifactory.shbmain.shb.biz | grep '^Aliases:' | wc -l)
if [[ in_hb_network -gt 0 ]]; then
	image=artifactory.shbmain.shb.biz/docker-registry-1.docker.io/ibmcom/websphere-liberty:latest
	echo "pulling $image from artifactory"
else
	image=icr.io/appcafe/websphere-liberty:latest
	echo "pulling $image from docker hub"
fi

cd "${0:A:h}"
docker pull $image
docker run --rm --name websphere_liberty $image &
sleep 15
rm -rf out
mkdir out
docker cp websphere_liberty:/opt/ibm/wlp out/
./stop.sh
