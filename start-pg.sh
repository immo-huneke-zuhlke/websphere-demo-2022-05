#!/usr/bin/env zsh

blocked=$(curl --noproxy '*' http://bbc.co.uk/ | grep -i 'Page Blocked' | wc -l)
if [[ blocked -gt 0 ]]; then
        image=artifactory.shbmain.shb.biz/docker-registry-1.docker.io/bitnami/postgresql:11.11.0-debian-10-r31
else
        image=postgres:latest
fi

cd "${0:A:h}"

docker run -p 5432:5432 --name docker-postgres -e POSTGRES_PASSWORD=postgrespw -d $image
