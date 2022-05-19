#!/usr/bin/env zsh

in_hb_network=$(nslookup artifactory.shbmain.shb.biz | grep '^Aliases:' | wc -l)
if [[ in_hb_network -gt 0 ]]; then
	image=artifactory.shbmain.shb.biz/docker-registry.access.redhat.com/rhscl/postgresql-10-rhel7:latest
        echo "pulling $image from artifactory"
else
        image=postgres:latest
	echo "pulling $image from docker hub"
fi

cd "${0:A:h}"

docker run -p 5432:5432 --name docker-postgres -e POSTGRES_PASSWORD=postgrespw -d $image
