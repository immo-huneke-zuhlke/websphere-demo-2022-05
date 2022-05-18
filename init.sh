#!/usr/bin/env zsh

blocked=$(curl --noproxy '*' http://bbc.co.uk/ | grep -i 'Page Blocked' | wc -l)
if [[ blocked -gt 0 ]]; then
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
